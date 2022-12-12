package com.gitlab.practice.service;

import com.gitlab.practice.domain.dto.UserJoinRequest;
import com.gitlab.practice.domain.dto.UserJoinResponse;
import com.gitlab.practice.domain.entity.User;
import com.gitlab.practice.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    public UserJoinResponse join(UserJoinRequest dto) {
        userRepository.findByUserName(dto.getUserName())
                .ifPresent(user -> {
                    throw new RuntimeException();
                });
        User savedUser = userRepository.save(
                dto.toEntity(encoder.encode(dto.getPassword()))
        );
        return UserJoinResponse.builder()
                .userName(savedUser.getUserName())
                .build();
    }
}
