package com.example.product_final.mapper;

import com.example.product_final.domain.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    List<ProductVO> selectTest();

}
