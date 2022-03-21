package com.example.bank.service.jpa;

import com.example.bank.entity.jpa.VueJpaMember;
import com.example.bank.repository.jpa.VueJpaMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VueJpaMemberServiceImpl implements VueJpaMemberService {

    @Autowired
    private VueJpaMemberRepository repository;

    @Override
    public void register(VueJpaMember member) {
        repository.save(member);
    }
}
