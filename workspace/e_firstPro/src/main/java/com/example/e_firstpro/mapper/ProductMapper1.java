package com.example.e_firstpro.mapper;

import com.example.e_firstpro.domain.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper1 {

    void insert(ProductVO vo);

    List<ProductVO> findByName(String name);

    List<ProductVO> findByConditions(String name, String category, int price);

}
