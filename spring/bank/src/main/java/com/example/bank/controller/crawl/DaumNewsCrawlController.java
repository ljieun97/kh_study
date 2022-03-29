package com.example.bank.controller.crawl;

import com.example.bank.entity.crawl.DaumNews;
import com.example.bank.service.crawl.DaumNewsCrawlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/crawl")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class DaumNewsCrawlController {

    @Autowired
    DaumNewsCrawlService service;

    @GetMapping("/{category}")
    public List<DaumNews> getDaumNewsCategory (@PathVariable String category) {
        log.info("Start Crawling: " + category);

        service.daumNewsMainCrawler(category);

        return service.daumNewsFindAll();
    }
}
