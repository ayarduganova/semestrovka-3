package ru.kpfu.itis.springbootsemestrovka.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.springbootsemestrovka.entity.RoleEntity;
import ru.kpfu.itis.springbootsemestrovka.repository.RoleRepository;
import ru.kpfu.itis.springbootsemestrovka.security.user.Role;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public void setRoles() {
        for (Role role : Role.values()) {
            RoleEntity roleEntity = RoleEntity.builder()
                                    .role(role)
                                    .build();
            roleRepository.save(roleEntity);
        }
    }

    public Set<RoleEntity> getUserRole() {
        return Set.of(roleRepository.getRoleEntityByRole(Role.USER));
    }

    public List<RoleEntity> allRoles(){
        return roleRepository.findAll();
    }
}
