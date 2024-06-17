package com.example.board.mapper;

import com.example.board.domain.dto.UsersDTO;
import com.example.board.domain.vo.UsersVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersMapper {

    UsersDTO findByProviderId(String providerId);

    void saveUser(UsersVO vo);

    void updateUser(UsersVO vo);

}
