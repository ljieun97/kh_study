package com.example.bank.repository.jpa;

import com.example.bank.entity.jpa.JpaMemberBoth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface JpaBmRepository extends JpaRepository<JpaMemberBoth, Long> {

    @Transactional
    @Query(value = "select * from jpa_member_both where member_no in(select jpa_member_both_member_no from jpa_member_auth_both where auth = :auth)", nativeQuery = true)
    public List<JpaMemberBoth> selectMemberWithRole(String auth);
}
