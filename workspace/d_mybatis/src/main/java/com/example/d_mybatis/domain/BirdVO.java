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

//   빌더 패턴은 하나만!
    @Builder
    public BirdVO (int id, String name, int age, String gender){
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

}
