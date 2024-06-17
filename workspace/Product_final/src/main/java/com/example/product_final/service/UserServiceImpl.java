package com.example.product_final.service;

import com.example.product_final.domain.dto.UserDTO;
import com.example.product_final.domain.vo.UserVO;
import com.example.product_final.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void save(UserDTO dto) {
        dto.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        UserVO vo = UserVO.toEntity(dto);

        userMapper.insert(vo);
    }
}
