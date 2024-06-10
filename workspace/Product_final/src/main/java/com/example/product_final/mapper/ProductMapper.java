package com.example.product_final.mapper;

import com.example.product_final.domain.dto.ProductDTO;
import com.example.product_final.domain.dto.ProductDetailDTO;
import com.example.product_final.domain.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    List<ProductVO> selectTest();

    // 리스트 화면에 뿌려줄 SQL
    List<ProductDTO> selectList();

    // 상세보기 페이지에 뿌려줄 SQL
    ProductDetailDTO selectOne(Long id);

    // 새 물품 등록 SQL
    void insert(ProductVO vo);

    // 업데이트
    void update(ProductVO vo);

}
