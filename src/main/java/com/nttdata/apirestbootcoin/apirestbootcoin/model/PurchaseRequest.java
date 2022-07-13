package com.nttdata.apirestbootcoin.apirestbootcoin.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Document(collection = "purchaseRequests")
public class PurchaseRequest {
    @Id
    private String id;
    private String cellNumber; //SOLICITANTE
    private BigDecimal amount;
    private String idPayMode;
    private boolean accept;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate creationDate = LocalDate.now();

}
