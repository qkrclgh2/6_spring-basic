package com.example.e_firstpro.domain.vo;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProductVO {
    private Long id;
    private String name;
    private Double price;
    private String category;
    private String description;

    public ProductVO() {}

    @Builder
    public ProductVO(Long id, String name, Double price, String category, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
    }
}
