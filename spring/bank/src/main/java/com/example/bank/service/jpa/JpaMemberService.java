package com.example.bank.service.jpa;


import com.example.bank.controller.jpa.MemberRequest;

public interface JpaMemberService {
    public void register (MemberRequest memberRequest);
    public MemberRequest login (MemberRequest memberRequest);
    
}