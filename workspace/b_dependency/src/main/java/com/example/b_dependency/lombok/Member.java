package com.example.b_dependency.lombok;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
//@Getter
//@Setter
//@ToString
//@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
@Data

public class Member {


    private String name;
    private int age;
    private String gender;
    private String address;

}
