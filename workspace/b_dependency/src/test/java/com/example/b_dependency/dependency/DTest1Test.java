package com.example.b_dependency.dependency;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DTest1Test {
    
//    // 필드 주입
//    @Autowired
//    private Dtest1 dtest1;

    // setter 주입
//    private DTest1 dTest1;
//
//    @Autowired
//    public void setDTest1 (DTest1 dTest1){
//        this.dTest1 = dTest1;
//    }

    // 생성자 주입
//    private final DTest1 dTest1;
//
//    @Autowired
    // Autowired 는 test 환경에서는 무조건 붙여줘야합니다.
//    public DTest1Test(DTest1 dTest1){
//        this.dTest1 = dTest1;
//    }
//
//    @Test
//    void print() {
////        Dtest1 test1 = new Dtest1();
////        test1.print();
//        dTest1.print();
//    }


}