package ru.kpfu.itis.springbootsemestrovka.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.springbootsemestrovka.dto.req.UserSignUpRequest;
import ru.kpfu.itis.springbootsemestrovka.entity.UserEntity;
import ru.kpfu.itis.springbootsemestrovka.security.user.Role;

import java.util.Set;

@RequiredArgsConstructor
@Component
public class UserMapper implements StandartMapper<UserSignUpRequest, UserEntity> {

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserEntity toEntity(UserSignUpRequest userSignUpRequest) {
        return UserEntity.builder()
                .username(userSignUpRequest.username())
                .password(passwordEncoder.encode(userSignUpRequest.password()))
                .roles(Set.of(Role.USER))
                .isActive(true)
                .isAdmin(false)
                .build();
    }

    @Override
    public UserEntity updateEntityFromRequest(UserSignUpRequest userSignUpRequest, UserEntity user) {
        return null;
    }

}

