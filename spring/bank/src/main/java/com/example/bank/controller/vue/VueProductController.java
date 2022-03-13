package com.example.bank.controller.vue;


import com.example.bank.entity.bank10.ProductBoard;
import com.example.bank.service.bank10.ProductBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/bank13")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class VueProductController {

    @Autowired
    private ProductBoardService service;

    @ResponseBody
    @GetMapping("/list")
    public ResponseEntity<List<ProductBoard>> getVueProductList() {
        log.info("getVueProductList()");

        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }
}
