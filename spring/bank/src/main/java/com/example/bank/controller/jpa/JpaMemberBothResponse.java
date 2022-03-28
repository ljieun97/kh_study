package com.example.bank.controller.jpa;

import lombok.Data;

@Data
public class JpaMemberBothResponse {
    private String userId;

    public JpaMemberBothResponse(String userId) {
        this.userId = userId;
    }

}
