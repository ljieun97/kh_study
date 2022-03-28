package com.example.bank.service.jpa;

import com.example.bank.controller.jpa.MemberRequest;
import com.example.bank.entity.jpa.JpaMemberAuthBoth;
import com.example.bank.entity.jpa.JpaMemberBoth;
import com.example.bank.repository.jpa.JpaBmAuthRepository;
import com.example.bank.repository.jpa.JpaBmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class JpaBmServiceImpl implements JpaBmService{

    @Autowired
    private JpaBmRepository memberRepository;

    @Autowired
    private JpaBmAuthRepository memberAuthRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void register(MemberRequest memberRequest) {
        String encodedPassword = passwordEncoder.encode(memberRequest.getPw());
        memberRequest.setPw(encodedPassword);

        JpaMemberBoth memberEntity = new JpaMemberBoth(
                memberRequest.getId(), memberRequest.getPw());


        memberRepository.save(memberEntity);

        JpaMemberAuthBoth authEntity = new JpaMemberAuthBoth(memberRequest.getAuth(), memberEntity);

        memberAuthRepository.save(authEntity);
    }

    @Override
    public List<JpaMemberBoth> findBusiness() {
        List<JpaMemberBoth> businessMember = memberRepository.selectMemberWithRole("사업자");
        return businessMember;
    }
}
