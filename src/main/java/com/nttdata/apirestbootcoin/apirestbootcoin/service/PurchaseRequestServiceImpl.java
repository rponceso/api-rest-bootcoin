package com.nttdata.apirestbootcoin.apirestbootcoin.service;

import com.nttdata.apirestbootcoin.apirestbootcoin.model.PurchaseRequest;
import com.nttdata.apirestbootcoin.apirestbootcoin.repository.PurchaseRequestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PurchaseRequestServiceImpl implements PurchaseRequestService {

    @Autowired
    private PurchaseRequestRepository repository;

    private final PurchaseRequestEventsService purchaseRequestEventsService;

    Logger logger = LoggerFactory.getLogger(PurchaseRequestServiceImpl.class);

    @Autowired
    public PurchaseRequestServiceImpl(PurchaseRequestEventsService purchaseRequestEventsService) {
        this.purchaseRequestEventsService = purchaseRequestEventsService;
    }

    @Override
    public Mono<PurchaseRequest> create(PurchaseRequest purchaseRequest) {
        logger.info("Received " + purchaseRequest);

        this.purchaseRequestEventsService.publish(purchaseRequest);
        return repository.save(purchaseRequest);
    }

    @Override
    public Flux<PurchaseRequest> listAll() {
        return repository.findAll();
    }

    @Override
    public Mono<PurchaseRequest> getById(String id) {
        return repository.findById(id);
    }
}
