package com.example.board.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UsersDTO {

    private String name;
    private String profilePic;
    private String provider;
    private String providerId;
    private String createAt;
    private String updateAt;


}
