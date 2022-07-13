package com.nttdata.apirestbootcoin.apirestbootcoin.controller;

import com.nttdata.apirestbootcoin.apirestbootcoin.model.WalletBootCoin;
import com.nttdata.apirestbootcoin.apirestbootcoin.service.WalletBootCoinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@RequestMapping("/api/bootcoin")
public class WalletBootCoinController {

    @Autowired
    private WalletBootCoinService service;

    private static final Logger log = LoggerFactory.getLogger(WalletBootCoinController.class);

    @GetMapping
    public Mono<ResponseEntity<Flux<WalletBootCoin>>> list() {
        Flux<WalletBootCoin> fxWallets = service.listAll();

        return Mono.just(ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fxWallets));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<WalletBootCoin>> getForId(@PathVariable("id") String id) {
        log.info("Se obtendra el wallet por Id");
        return service.getById(id)
                .map(w -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(w)
                )
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<ResponseEntity<WalletBootCoin>> register(@RequestBody WalletBootCoin walletBootCoin, final ServerHttpRequest req) {
        return service.create(walletBootCoin)
                .map(w -> ResponseEntity.created(URI.create(req.getURI().toString().concat("/").concat(w.getId())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(w)
                );

    }

}
