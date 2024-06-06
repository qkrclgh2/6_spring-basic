package com.example.d_mybatis.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BirdVO {

    private int id;
    private String name;
    private int age;
    private String gender;

    public BirdVO() {}

    @Builder
    public BirdVO (String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

}
