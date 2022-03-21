package com.example.bank.controller.jpa;

import com.example.bank.entity.jpa.VueJpaMember;
import com.example.bank.service.jpa.VueJpaMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/vueJpaMember")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class VueJpaMemberController {

    @Autowired
    private VueJpaMemberService service;

    @PostMapping("/register")
    public VueJpaMember register (@Validated @RequestBody VueJpaMember member) {
        log.info("register request from vue: " + member);

        service.register(member);

        return member;
    }
}
