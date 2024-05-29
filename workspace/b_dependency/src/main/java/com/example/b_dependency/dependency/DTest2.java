package com.example.b_dependency.dependency;

import org.springframework.stereotype.Component;

@Component
public class DTest2 {

    private final DTest1 dTest1;

    public DTest2(DTest1 dTest1) {
        this.dTest1 = dTest1;
    }

    public void print2() {
        dTest1.print();
        System.out.println("DTest2");
    }

}
