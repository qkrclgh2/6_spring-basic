package com.example.board.service;

import com.example.board.domain.dto.UsersDTO;
import com.example.board.domain.oauth.CustomOAuth2User;
import com.example.board.domain.vo.UsersVO;
import com.example.board.mapper.UsersMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UsersMapper usersMapper;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        String name = null;
        String profileUrl = null;
        String providerId = null;

        // OAuth2로부터 받은 사용자 정보
        Map<String, Object> attribute = oAuth2User.getAttributes();
        providerId = attribute.get("id").toString();

        // 세부적으로 한 번 더 들어가야된다.
        Map<String, Object> account = (Map<String, Object>)attribute.get("kakao_account");

        // 한 번 더 들어간다.
        Map<String, Object> info = (Map<String, Object>)account.get("profile");

        name = (String)info.get("nickname");
        profileUrl = (String)info.get("profile_image_url");

        UsersDTO loginUser = new UsersDTO();
        loginUser.setName(name);
        loginUser.setProviderId(providerId);
        loginUser.setProfilePic(profileUrl);
        loginUser.setProvider(userRequest.getClientRegistration().getRegistrationId()); // OAuth2 공급자의 이름

        UsersVO user = UsersVO.toEntity(loginUser);
        // DB 저장 및 업데이트 로직
        UsersDTO existingUser = usersMapper.findByProviderId(providerId);
        
        // 우리 애플리케이션에 가입한 적이 없는 OAuth 계정
        if(existingUser == null){
            // insert
            usersMapper.saveUser(user);
        }
        // 가입 이력이 있다면, 정보 업데이트
        else {
            usersMapper.updateUser(user);
        }
//        return oAuth2User;
        return new CustomOAuth2User(oAuth2User, name, profileUrl, providerId);
    }
}
