package com.example.product_final.controller;

import com.example.product_final.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
// RequestMapping 은 FrontController 하는 역할을 수행한다
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @GetMapping
    public String index(){
//        return "product/index.html";
        // 기본 시작경로는 templates
        // 우리 인덱스 페이지는 product 안에 있기에 경로를 명시!
        // 뒤에 .html 확장자는 생략이 가능하다.
        return "product/index";
    }

    @GetMapping("/list")
    // Model 은 컨트롤러에서 html로 데이터를 전달하기 위해 사용하는 객체.
    // 해당 객체에 데이터를 저장, 그리고 html로 가서 타임리프 뿌려줌
    public String list(Model model){
        // 앞에 적어준 문자열을 html 내에서 사용할 데이터의 이름.
        // 뒤에는 실제 전송하는 데이터.
        
        // th:if 사용 전 하나만 넘겨보기
        model.addAttribute("products", productService.findAll());
//        model.addAttribute("product", productService.findAll().get(0));

        return "product/productList";
    }

}
