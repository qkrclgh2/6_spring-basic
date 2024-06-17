package com.example.product_final.mapper;

import com.example.product_final.domain.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void insert(UserVO vo);

    UserVO selectOne(String userId);

}
