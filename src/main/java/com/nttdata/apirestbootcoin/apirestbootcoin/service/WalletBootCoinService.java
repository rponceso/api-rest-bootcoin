/**
 * Interface Service Customer
 *
 * @author Renato Ponce
 * @version 1.0
 * @since 2022-06-24
 */

package com.nttdata.apirestbootcoin.apirestbootcoin.service;


import com.nttdata.apirestbootcoin.apirestbootcoin.model.WalletBootCoin;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface WalletBootCoinService {

    Mono<WalletBootCoin> create(WalletBootCoin walletBootCoin);

    Flux<WalletBootCoin> listAll();

    Mono<WalletBootCoin> getById(String id);


}
