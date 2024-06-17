package com.example.board.domain.vo;

import com.example.board.domain.dto.UsersDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter
@ToString
@NoArgsConstructor
public class UsersVO {

    private String name;
    private String profilePic;
    private String provider;
    private String providerId;
    private String createAt;
    private String updateAt;

    @Builder
    public UsersVO(String name, String profilePic, String provider, String providerId, String createAt, String updateAt) {
        this.name = name;
        this.profilePic = profilePic;
        this.provider = provider;
        this.providerId = providerId;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public static UsersVO toEntity(UsersDTO dto){
        return UsersVO.builder().name(dto.getName())
                .profilePic(dto.getProfilePic())
                .provider(dto.getProvider())
                .providerId(dto.getProviderId())
                .createAt(dto.getCreateAt())
                .updateAt(dto.getUpdateAt())
                .build();
    }

}
