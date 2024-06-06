package com.example.e_firstpro.mapper;

import com.example.e_firstpro.domain.vo.ProductVO;
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
    void selectByIdTest() {
        log.info(productMapper.selectById(1).toString());
    }

    @Test
    void selectAllTest() {
        log.info(productMapper.selectAll().toString());
    }

    @Test
    void insertTest() {
        ProductVO productVO = ProductVO.builder()
                .name("껌")
                .price(300.0)
                .category("스낵")
                .description("good")
                .build();

        productMapper.insert(productVO);
    }

    @Test
    void deleteByIdTest() {
        productMapper.deleteById(1);
    }

}