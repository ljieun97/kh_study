package com.example.bank.service.jpa;

import com.example.bank.controller.jpa.MemberRequest;
import com.example.bank.entity.jpa.VueJpaMemberAuth;
import com.example.bank.entity.jpa.VueJpaMemberWithAuth;
import com.example.bank.repository.jpa.VueJpaMemberWithAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class JpaMemberServiceImpl implements JpaMemberService{

    @Autowired
    private VueJpaMemberWithAuthRepository memberRepository;

    @Override
    public void register(MemberRequest memberRequest) {
        VueJpaMemberAuth authEntity = new VueJpaMemberAuth(memberRequest.getAuth());
        VueJpaMemberWithAuth memberEntity = new VueJpaMemberWithAuth(memberRequest.getId(), memberRequest.getPw());

        memberEntity.addAuth(authEntity);
        memberRepository.save(memberEntity);
    }
}
