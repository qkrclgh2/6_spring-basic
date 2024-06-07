package com.example.product_final.mapper;

import com.example.product_final.domain.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class ProductMapperTest {

    @Autowired
    private ProductMapper productMapper;

    @Test
    void test(){
        productMapper.selectTest().stream().map(ProductVO::toString).forEach(log::info);
    }

}