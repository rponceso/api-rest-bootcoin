package com.nttdata.apirestbootcoin.apirestbootcoin.service;

import com.nttdata.apirestbootcoin.apirestbootcoin.model.ExchangeRate;
import com.nttdata.apirestbootcoin.apirestbootcoin.model.WalletBootCoin;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ExchangeRateService {

    Mono<ExchangeRate> create(ExchangeRate exchangeRate);

    Flux<ExchangeRate> listAll();

    Mono<ExchangeRate> getById(String id);

}
