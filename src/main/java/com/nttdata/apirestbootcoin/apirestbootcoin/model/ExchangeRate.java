package com.nttdata.apirestbootcoin.apirestbootcoin.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document(collection = "exchangeRates")
public class ExchangeRate {

    @Id
    private String id;
    private BigDecimal purchaseRate;
    private BigDecimal sellingRate;
}
