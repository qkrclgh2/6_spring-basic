package com.example.b_dependency.dependency;

import org.springframework.stereotype.Component;

// 스프링 컨테이너에 등록해줘
@Component
public class DTest1 {

    public void print (){
        System.out.println("DTest1");
    }

}
