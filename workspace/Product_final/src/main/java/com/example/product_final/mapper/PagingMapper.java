package com.example.product_final.mapper;

import com.example.product_final.domain.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PagingMapper {

    // 페이징 처리가 된 select
    List<ProductDTO> selectPaging(@Param("startRow") int startRow, int endRow);

    // 행의 갯수를 가져오는 select
    int countProducts();

}