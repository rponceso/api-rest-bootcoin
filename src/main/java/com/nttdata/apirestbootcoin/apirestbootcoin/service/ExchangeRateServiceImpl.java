package com.nttdata.apirestbootcoin.apirestbootcoin.service;

import com.nttdata.apirestbootcoin.apirestbootcoin.model.ExchangeRate;
import com.nttdata.apirestbootcoin.apirestbootcoin.repository.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Autowired
    private ExchangeRateRepository repository;

    @Override
    public Mono<ExchangeRate> create(ExchangeRate exchangeRate) {
        return repository.save(exchangeRate);
    }

    @Override
    public Flux<ExchangeRate> listAll() {
        return repository.findAll();
    }

    @Override
    public Mono<ExchangeRate> getById(String id) {
        return repository.findById(id);
    }
}
