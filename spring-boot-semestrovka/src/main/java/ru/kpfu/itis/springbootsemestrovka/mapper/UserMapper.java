package ru.kpfu.itis.springbootsemestrovka.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.springbootsemestrovka.dto.req.UserInfoRequest;
import ru.kpfu.itis.springbootsemestrovka.dto.req.UserSignUpRequest;
import ru.kpfu.itis.springbootsemestrovka.dto.resp.PostResponse;
import ru.kpfu.itis.springbootsemestrovka.dto.resp.UserResponse;
import ru.kpfu.itis.springbootsemestrovka.entity.PostEntity;
import ru.kpfu.itis.springbootsemestrovka.entity.RoleEntity;
import ru.kpfu.itis.springbootsemestrovka.entity.UserEntity;
import ru.kpfu.itis.springbootsemestrovka.security.user.Role;
import ru.kpfu.itis.springbootsemestrovka.service.RoleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Component
public class UserMapper implements StandartMapper<UserSignUpRequest, UserEntity, UserResponse> {

    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    @Override
    public UserEntity toEntity(UserSignUpRequest userSignUpRequest) {
        return UserEntity.builder()
                .username(userSignUpRequest.username())
                .password(passwordEncoder.encode(userSignUpRequest.password()))
                .roles(roleService.getUserRole())
                .isActive(true)
                .isAdmin(false)
                .build();
    }

    @Override
    public UserEntity updateEntityFromRequest(UserSignUpRequest userSignUpRequest, UserEntity user) {
        return null;
    }

    @Override
    public UserResponse toResponse(UserEntity user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .roles(user.getRoles())
                .isActive(user.isActive())
                .build();
    }

    public List<UserResponse> toListResponse(List<UserEntity> userEntityList){
        List<UserResponse> userResponses = new ArrayList<>();
        for(UserEntity userEntity : userEntityList){
            userResponses.add(toResponse(userEntity));
        }
        return userResponses;
    }

}

