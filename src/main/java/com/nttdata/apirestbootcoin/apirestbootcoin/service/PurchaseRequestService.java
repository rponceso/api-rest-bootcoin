package com.nttdata.apirestbootcoin.apirestbootcoin.service;

import com.nttdata.apirestbootcoin.apirestbootcoin.model.PurchaseRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PurchaseRequestService {

    Mono<PurchaseRequest> create(PurchaseRequest purchaseRequest);

    Flux<PurchaseRequest> listAll();

    Mono<PurchaseRequest> getById(String id);

}
