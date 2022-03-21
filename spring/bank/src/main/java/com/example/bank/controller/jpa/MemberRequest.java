package com.example.bank.controller.jpa;

import lombok.Data;

@Data
public class MemberRequest {
    private String id;
    private String pw;
    private String auth;

    public MemberRequest (String id, String pw, String auth) {
        this.id = id;
        this.pw = pw;
        this.auth = auth;
    }
}
