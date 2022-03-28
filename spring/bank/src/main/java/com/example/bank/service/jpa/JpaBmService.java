package com.example.bank.service.jpa;

import com.example.bank.controller.jpa.MemberRequest;
import com.example.bank.entity.jpa.JpaMemberBoth;

import java.util.List;

public interface JpaBmService {
    public void register (MemberRequest memberRequest);
    List<JpaMemberBoth> findBusiness ();
}
