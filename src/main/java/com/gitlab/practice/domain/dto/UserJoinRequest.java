package com.gitlab.practice.domain.dto;

import com.gitlab.practice.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class UserJoinRequest {
    private String userName;
    private String password;

    public User toEntity() {
        return User.builder()
                .userName(this.userName)
                .password(password)
                .build();
    }
}
