package com.example.bank.repository.jpa;

import com.example.bank.entity.jpa.JpaMemberAuthBoth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBmAuthRepository extends JpaRepository<JpaMemberAuthBoth, Long> {
}
