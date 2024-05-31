package ru.kpfu.itis.springbootsemestrovka.mapper;

import org.springframework.stereotype.Component;
import ru.kpfu.itis.springbootsemestrovka.entity.RoleEntity;
import ru.kpfu.itis.springbootsemestrovka.security.user.Role;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class RoleMapper {

    public RoleEntity toEntity(Role role){
        return RoleEntity.builder()
                .role(role)
                .build();
    }

    public Set<RoleEntity> toListRoleEntity(Set<Role> roles){

        Set<RoleEntity> roleEntities = new HashSet<>();

        for(Role role : roles){
            roleEntities.add(toEntity(role));
        }

        return roleEntities;
    }

    public Set<Role> toListRole(Set<RoleEntity> roleEntities){

        Set<Role> role = new HashSet<>();

        for(RoleEntity roleEntity : roleEntities){
            role.add(roleEntity.getRole());
        }

        return role;
    }

}
