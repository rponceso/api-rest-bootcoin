package com.nttdata.apirestbootcoin.apirestbootcoin.controller;

import com.nttdata.apirestbootcoin.apirestbootcoin.model.PurchaseRequest;
import com.nttdata.apirestbootcoin.apirestbootcoin.service.PurchaseRequestService;
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
@RequestMapping("/api/purchaserequest")
public class PurchaseRequestController {

    @Autowired
    private PurchaseRequestService service;

    private static final Logger log = LoggerFactory.getLogger(PurchaseRequestController.class);

    @GetMapping
    public Mono<ResponseEntity<Flux<PurchaseRequest>>> list() {
        Flux<PurchaseRequest> fxPurchaseRequests = service.listAll();

        return Mono.just(ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fxPurchaseRequests));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<PurchaseRequest>> getForId(@PathVariable("id") String id) {
        log.info("Se obtendra el PurchaseRequest por Id");
        return service.getById(id)
                .map(p -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(p)
                )
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<ResponseEntity<PurchaseRequest>> register(@RequestBody PurchaseRequest purchaseRequest, final ServerHttpRequest req) {
        return service.create(purchaseRequest)
                .map(p -> ResponseEntity.created(URI.create(req.getURI().toString().concat("/").concat(p.getId())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(p)
                );

    }
}
