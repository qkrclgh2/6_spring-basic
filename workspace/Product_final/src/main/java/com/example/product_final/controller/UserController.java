package com.example.product_final.controller;

import com.example.product_final.domain.dto.UserDTO;
import com.example.product_final.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "/login/login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "/login/signup";
    }

    @PostMapping("/signup")
    public String signup(UserDTO dto) {
        log.info("html 넘어온 데이터!!!!!!!!!    " + dto.toString());

        userService.save(dto);

        return "/login/login";
    }

}