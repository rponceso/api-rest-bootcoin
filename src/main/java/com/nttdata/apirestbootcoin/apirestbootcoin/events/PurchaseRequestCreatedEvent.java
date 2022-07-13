package com.nttdata.apirestbootcoin.apirestbootcoin.events;

import com.nttdata.apirestbootcoin.apirestbootcoin.model.PurchaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PurchaseRequestCreatedEvent extends Event<PurchaseRequest> {

}
