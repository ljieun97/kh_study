package com.example.bank.repository.jpa;

import com.example.bank.entity.jpa.JpaBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBoardRepository extends JpaRepository<JpaBoard, Long> {
}
