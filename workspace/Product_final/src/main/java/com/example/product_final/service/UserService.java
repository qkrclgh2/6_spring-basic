package com.example.product_final.service;

import com.example.product_final.domain.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public void save(UserDTO dto);

}
