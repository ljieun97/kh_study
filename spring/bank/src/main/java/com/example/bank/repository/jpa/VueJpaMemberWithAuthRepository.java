package com.example.bank.repository.jpa;

import com.example.bank.entity.jpa.VueJpaMemberWithAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface VueJpaMemberWithAuthRepository extends JpaRepository<VueJpaMemberWithAuth, Long> {
    //VueJpaMemberWithAuth를 m이라고 별명을 붙여서 해당 userId의 m전체를 보겠다는것
    //noargsConstructor 필요
    @Query("select m from VueJpaMemberWithAuth m where m.userId = :userId")
    Optional<VueJpaMemberWithAuth> findByUserId(String userId);
}