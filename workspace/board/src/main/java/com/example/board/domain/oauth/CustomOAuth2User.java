package com.example.board.domain.oauth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

// 이 친구를 만든 OAuth2User 인터페이스를 구현하여,
// 사용자 정보와 추가적인 사용자 세부 정보를 저장하고
// 우리가 정한 양식으로 간편하게 들고 나올 수 있다.
@Getter
@AllArgsConstructor
public class CustomOAuth2User implements OAuth2User {

    private final OAuth2User oAuth2User;
    private final String name;
    private final String profilePic;
    private final String providerId;

    @Override
    public Map<String, Object> getAttributes() {
        return oAuth2User.getAttributes();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return oAuth2User.getAuthorities();
    }
}
