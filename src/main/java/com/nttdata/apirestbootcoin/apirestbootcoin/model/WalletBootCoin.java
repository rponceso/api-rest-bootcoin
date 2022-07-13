package com.nttdata.apirestbootcoin.apirestbootcoin.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "wallets")
public class WalletBootCoin {
    @Id
    private String id;
    private String documentType;
    private String documentNumber;
    private String cellNumber;
    private String email;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate creationDate = LocalDate.now();

}
