package com.example.product_final.config;

import com.example.product_final.service.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity // 웹 보안 활성화, Spring Security
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserDetailService userDetailService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // 전체 요청에 접근할 수 있도록 하는 코드.
//        return http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
//                .build();

        return http
                // 요청에 대한 인증 및 인가를 설정.
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                new AntPathRequestMatcher("/product/list", "GET"),
                                new AntPathRequestMatcher("/product"),
                                new AntPathRequestMatcher("/user/login"),
                                new AntPathRequestMatcher("/user/signup")
                        ).permitAll() // 특정 요청에 대해서는 접근을 허용한다.
                        .anyRequest().authenticated() // 나머지 요청들은 인증이 필요하도록 할 것이다.
                )
                // 로그인을 폼 기반으로 구성할 것이다.
                .formLogin(form -> form
                                .loginPage("/user/login") // 내가 사용할 로그인 페이지 요청 설정.
                                .usernameParameter("userId") // 사용자 ID 필드의 이름을 설정.
//                        .passwordParameter("password") // 필드의 이름과 동일하다면 생략 가능!
//                        .defaultSuccessUrl("/product/list")
                                .successHandler(authenticationSuccessHandler())

                )
                .logout(logout -> logout
                        .logoutUrl("/user/logout")
                        .invalidateHttpSession(true) // 현재 세션 무효화
                )
                .build();
    }

    // 사용자가 로그인 할 때, 인증 요청을 처리하는 친구.
    @Bean
    public AuthenticationManager authenticationManager(BCryptPasswordEncoder bCryptPasswordEncoder) throws Exception {

        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailService);
        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder);
        return new ProviderManager(daoAuthenticationProvider);
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return (request, response, auth) -> {
            response.sendRedirect("/product/list");
        };
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


}