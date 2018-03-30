package com.singletonapps.webflux.tradingservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TradingUser {

    @Id
    private String id;
    private String userName;
    private String fullName;

    public TradingUser(String userName, String fullName) {
        this.userName = userName;
        this.fullName = fullName;
    }
}
