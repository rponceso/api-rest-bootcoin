package com.nttdata.apirestbootcoin.apirestbootcoin.controller;

import com.nttdata.apirestbootcoin.apirestbootcoin.model.ExchangeRate;
import com.nttdata.apirestbootcoin.apirestbootcoin.model.WalletBootCoin;
import com.nttdata.apirestbootcoin.apirestbootcoin.service.ExchangeRateService;
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
@RequestMapping("/api/exchangerate")
public class ExchangeRateController {

    @Autowired
    private ExchangeRateService service;

    private static final Logger log = LoggerFactory.getLogger(ExchangeRateController.class);

    @GetMapping
    public Mono<ResponseEntity<Flux<ExchangeRate>>> list() {
        Flux<ExchangeRate> fxExchangeRates = service.listAll();

        return Mono.just(ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fxExchangeRates));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<ExchangeRate>> getForId(@PathVariable("id") String id) {
        log.info("Se obtendra el ExchangeRate por Id");
        return service.getById(id)
                .map(e -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(e)
                )
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<ResponseEntity<ExchangeRate>> register(@RequestBody ExchangeRate exchangeRate, final ServerHttpRequest req) {
        return service.create(exchangeRate)
                .map(e -> ResponseEntity.created(URI.create(req.getURI().toString().concat("/").concat(e.getId())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(e)
                );

    }


}
