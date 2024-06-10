package com.example.product_final.service;

import com.example.product_final.domain.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<ProductDTO> findAll();

}
