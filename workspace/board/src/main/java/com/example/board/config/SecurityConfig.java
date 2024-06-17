package com.example.board.config;

import com.example.board.service.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity // 웹 보안 활성화, Spring Security
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // 전체 요청에 접근할 수 있도록 하는 코드.
//        return http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
//                .build();

        return http
                // 요청에 대한 인증 및 인가를 설정.
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()
                )
                // 로그인을 OAuth2기반으로 구성할 것이다.
                .oauth2Login(login -> login
                        .userInfoEndpoint(userInfo -> userInfo
                                .userService(customOAuth2UserService)
                        ).successHandler(authenticationSuccessHandler())
                )

                .logout(logout -> logout
                        .logoutSuccessHandler((request, response, authentication) -> {
                            //
//                            String clientId = request.getParameter("ClientId");
                            String clientId = "5191f72db818882b4ce59372b3b1398a";
                            String logoutRedirectUri = "http://localhost:8090";
                            String logoutUri = "https://kauth.kakao.com/oauth/logout?client_id=" + clientId + "&logout_redirect_uri=" + logoutRedirectUri;
                            response.sendRedirect(logoutUri);
                        })
                )
                .build();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return (request, response, auth) -> {

            response.sendRedirect("/");
        };
    }



}
