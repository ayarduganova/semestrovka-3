package ru.kpfu.itis.springbootsemestrovka.dto.resp;

import lombok.Builder;
import ru.kpfu.itis.springbootsemestrovka.entity.RoleEntity;
import ru.kpfu.itis.springbootsemestrovka.security.user.Role;

import java.util.Set;

@Builder
public record UserResponse(Long id, String username, Set<RoleEntity> roles, boolean isActive) {
}
