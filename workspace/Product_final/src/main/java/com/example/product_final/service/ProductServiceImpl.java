package com.example.product_final.service;

import com.example.product_final.domain.dto.ProductDTO;
import com.example.product_final.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// 특정 변수의 생성자를 만들어주는 어노테이션
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    // 생성자 주입
    // @Autowired 생략 가능.
    private final ProductMapper productMapper;

    // 전체 물품 리스트를 반환하는 select
    @Override
    public List<ProductDTO> findAll() {
        return productMapper.selectList();
    }
}
