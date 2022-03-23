package com.example.bank.service.jpa;

import com.example.bank.controller.jpa.MemberRequest;
import com.example.bank.entity.jpa.VueJpaMemberAuth;
import com.example.bank.entity.jpa.VueJpaMemberWithAuth;
import com.example.bank.repository.jpa.VueJpaMemberAuthRepository;
import com.example.bank.repository.jpa.VueJpaMemberWithAuthRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class JpaMemberServiceImpl implements JpaMemberService{

    @Autowired
    private VueJpaMemberAuthRepository memberAuthRepository;

    @Autowired
    private VueJpaMemberWithAuthRepository memberRepository;

    //개인정보(비밀번호) 암호화
    //build.gradle 에 추가해야함, config도 만들어야함
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(MemberRequest memberRequest) {
        //개인정보(비밀번호) 암호화
        String encodePassword = passwordEncoder.encode(memberRequest.getPw());
        memberRequest.setPw(encodePassword);

        VueJpaMemberAuth authEntity = new VueJpaMemberAuth(memberRequest.getAuth());
        VueJpaMemberWithAuth memberEntity = new VueJpaMemberWithAuth(memberRequest.getId(), memberRequest.getPw());

        memberEntity.addAuth(authEntity);
        memberRepository.save(memberEntity);
    }

    @Override
    public MemberRequest login(MemberRequest memberRequest) {
        //gitId가 레퍼지토리에 존재하는지 확인해서 정보를 maybe에 저장, 없으면 null
        Optional<VueJpaMemberWithAuth> maybeMember = memberRepository.findByUserId(memberRequest.getId());

        if(maybeMember == null) {
            log.info("이런 사람 없다!");
            return null;
        }

        //있으면 로그인멤버에 정보저장
        VueJpaMemberWithAuth loginMember = maybeMember.get();

        //사용자가 입력한 비밀번호를 암호화하여 db에 저장된 암호와 비교
        if (!passwordEncoder.matches(memberRequest.getPw(), loginMember.getPassword())) {
            log.info("비밀번호를 잘 못 입력했습니다!");
            return null;
        }
        
        Optional<VueJpaMemberAuth> maybeMemberAuth = memberAuthRepository.findByMemberNo(loginMember.getMemberNo());

        if (maybeMemberAuth == null) {
            log.info("auth 없음");
            return null;
        }

        VueJpaMemberAuth memberAuth = maybeMemberAuth.get();
        MemberRequest response = new MemberRequest(memberRequest.getId(), null, memberAuth.getAuth());

        return response;
    }
    
    
}
