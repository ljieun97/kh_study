package com.example.bank.controller.jpa;

import com.example.bank.entity.jpa.JpaMemberBoth;
import com.example.bank.service.jpa.JpaBmService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/jpaMember")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class JpaBusinessMemberController {

    @Autowired
    private JpaBmService service;

    @PostMapping("/register")
    public void jpaMemberAuthRegister (@Validated @RequestBody MemberRequest memberRequest) {
        log.info("jpaMemberAuthRegister(): " + memberRequest.getId() + ", " +
                memberRequest.getPw() + ", " +
                (memberRequest.getAuth().equals("사업자") ? "ROLE_BUSINESS" : "ROLE_INDIVIDUAL"));

        service.register(memberRequest);
    }

    @GetMapping("/checkBusiness")
    public List<JpaMemberBothResponse> checkBusinessMember () {
        log.info("checkBusiness() ===> findBusinessMember!!!");

        List<JpaMemberBoth> businessMember = service.findBusiness();
        List<JpaMemberBothResponse> responses = new ArrayList<>();

        for (JpaMemberBoth member : businessMember) {
            responses.add(new JpaMemberBothResponse(member.getUserId()));
        }

        return responses;
    }
}
