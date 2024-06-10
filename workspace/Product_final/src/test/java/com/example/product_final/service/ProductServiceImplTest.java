package com.example.product_final.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ProductServiceImplTest {

    @Autowired
    private ProductService productService;

    @Test
    public void test() {
        log.info(productService.findById(16L).toString());
    }
}