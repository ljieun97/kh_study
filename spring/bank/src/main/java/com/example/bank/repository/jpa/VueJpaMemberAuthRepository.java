package com.example.bank.repository.jpa;

import com.example.bank.entity.jpa.VueJpaMemberAuth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface VueJpaMemberAuthRepository extends JpaRepository<VueJpaMemberAuth, Long> {
    @Query("select ma.auth from VueJpaMemberAuth ma where ma.memberNo = :memberNo")
    Optional<VueJpaMemberAuth> findByMemberNo(Long memberNo);
}
