package com.example.bank.controller.vue;


import com.example.bank.entity.bank10.ProductBoard;
import com.example.bank.service.bank10.ProductBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/bank13")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class VueProductController {

    @Autowired
    private ProductBoardService productBoardService;

    @ResponseBody
    @GetMapping("/list")
    public ResponseEntity<List<ProductBoard>> listProduct() {
        log.info("listProduct()");

        return new ResponseEntity<>(productBoardService.list(), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<ProductBoard> registerProduct(@RequestBody ProductBoard productBoard) {
        log.info("registerProduct()");

        productBoardService.register(productBoard);
        return new ResponseEntity<>(productBoard, HttpStatus.OK);
    }

    @GetMapping("/{productNo}")
    public ResponseEntity<ProductBoard> readProduct(@PathVariable("productNo") Integer productNo) {
        log.info("readProduct()");

        ProductBoard productBoard = productBoardService.read(productNo);
        return new ResponseEntity<>(productBoard, HttpStatus.OK);
    }

    @DeleteMapping("/{productNo}")
    public ResponseEntity<Void> removeProduct(@PathVariable("productNo") Integer productNo) {
        log.info("removeProduct()");

        productBoardService.remove(productNo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{productNo}")
    public ResponseEntity<ProductBoard> modifyProduct(@PathVariable("productNo") Integer productNo,
                                                @RequestBody ProductBoard productBoard) {
        log.info("modifyProduct()");

        productBoard.setProductNo(productNo);
        productBoardService.modify(productBoard);
        return new ResponseEntity<>(productBoard, HttpStatus.OK);
    }
}
