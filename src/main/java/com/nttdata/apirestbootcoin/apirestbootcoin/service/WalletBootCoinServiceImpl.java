package com.nttdata.apirestbootcoin.apirestbootcoin.service;

import com.nttdata.apirestbootcoin.apirestbootcoin.model.PurchaseRequest;
import com.nttdata.apirestbootcoin.apirestbootcoin.model.WalletBootCoin;
import com.nttdata.apirestbootcoin.apirestbootcoin.repository.WalletBootCoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class WalletBootCoinServiceImpl implements WalletBootCoinService {

    @Autowired
    private WalletBootCoinRepository repository;

    @Override
    public Mono<WalletBootCoin> create(WalletBootCoin walletBootCoin) {
        return repository.save(walletBootCoin);
    }

    @Override
    public Flux<WalletBootCoin> listAll() {
        return repository.findAll();
    }

    @Override
    public Mono<WalletBootCoin> getById(String id) {
        return repository.findById(id);
    }
}
