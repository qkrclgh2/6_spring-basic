package com.example.product_final.domain.dto;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

// 상세보기 페이지로 데이터를 넘기기 위한 DTO
@Component
@Data
@NoArgsConstructor
public class ProductDetailDTO {
    private Long id;
    private String name;
    private Double price;
    private String category;
    private String description;


    @Builder
    public ProductDetailDTO(Long id, String name, Double price, String category, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
    }
}
