package com.nttdata.apirestbootcoin.apirestbootcoin.service;

import com.nttdata.apirestbootcoin.apirestbootcoin.events.Event;
import com.nttdata.apirestbootcoin.apirestbootcoin.events.EventType;
import com.nttdata.apirestbootcoin.apirestbootcoin.events.PurchaseRequestCreatedEvent;
import com.nttdata.apirestbootcoin.apirestbootcoin.model.PurchaseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class PurchaseRequestEventsService {

    @Autowired
    private KafkaTemplate<String, Event<?>> producer;

    @Value("${topic.purchase.name:purchases}")
    private String topicPurchase;

    public void publish(PurchaseRequest purchaseRequest) {

        PurchaseRequestCreatedEvent created = new PurchaseRequestCreatedEvent();
        created.setData(purchaseRequest);
        created.setId(UUID.randomUUID().toString());
        created.setType(EventType.CREATED);
        created.setDate(new Date());

        this.producer.send(topicPurchase, created);
    }


}
