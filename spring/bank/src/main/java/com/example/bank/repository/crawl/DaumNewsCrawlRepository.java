package com.example.bank.repository.crawl;

import com.example.bank.entity.crawl.DaumNews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaumNewsCrawlRepository extends JpaRepository<DaumNews, Long> {
    public DaumNews findByNewsNo(String newsNo);

}
