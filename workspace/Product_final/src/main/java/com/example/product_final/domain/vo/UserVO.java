package com.example.product_final.domain.vo;

import com.example.product_final.domain.dto.UserDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
@Getter
@ToString
@NoArgsConstructor
// Spring security 의 UserDetails 를 지정 받아
// 해당 객체를 이용하여 사용자의 인증 및 권한을 처리할 수 있다.
public class UserVO implements UserDetails {

    // pk
    private Long id;

    // 회원 아이디
    private String userId;

    // 이메일
    private String email;

    // 비밀번호
    private String password;

    @Builder
    public UserVO(Long id, String userId, String email, String password) {
        this.id = id;
        this.userId = userId;
        this.email = email;
        this.password = password;
    }

    public static UserVO toEntity(UserDTO userDTO) {
        return UserVO.builder().userId(userDTO.getUserId())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .build();
    }

    // 사용자에게 부여된 권한 반환
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("basic"));
    }

    @Override
    public String getUsername() {
        return userId;
    }

    // 계정의 만료 여부
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 계정의 잠김 여부
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 자격 증명 만료 여부
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 계정의 활성화 여부
    @Override
    public boolean isEnabled() {
        return true;
    }
}
