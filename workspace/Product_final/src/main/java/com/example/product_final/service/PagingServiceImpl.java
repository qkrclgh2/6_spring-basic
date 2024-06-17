package com.example.product_final.service;

import com.example.product_final.domain.dto.ProductDTO;
import com.example.product_final.mapper.PagingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PagingServiceImpl implements PagingService {

    private final PagingMapper pagingMapper;

    @Override
    public List<ProductDTO> selectPaging(int pageNo, int pageSize) {

        int startRow = (pageNo - 1) * pageSize;
        int endRow = pageNo * pageSize;

        return pagingMapper.selectPaging(startRow, endRow);
    }

    @Override
    public int countProducts() {
        return pagingMapper.countProducts();
    }
}