package ru.kpfu.itis.springbootsemestrovka.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.springbootsemestrovka.dto.req.UserSignUpRequest;
import ru.kpfu.itis.springbootsemestrovka.entity.UserInfoEntity;
import ru.kpfu.itis.springbootsemestrovka.entity.UserEntity;
import ru.kpfu.itis.springbootsemestrovka.mapper.UserMapper;
import ru.kpfu.itis.springbootsemestrovka.repository.UserRepository;
import ru.kpfu.itis.springbootsemestrovka.security.user.Role;


import java.security.Key;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserEntity signUp(UserSignUpRequest userRequest) {
        return userRepository.save(userMapper.toEntity(userRequest));
    }

    public boolean exist(String username){
        return userRepository.existsByUsername(username);
    }

    public List<UserEntity> getAll(){
        return userRepository.findAll();
    }

    public void saveUser(UserEntity userEntity){
        userRepository.save(userEntity);
    }

    public void editUser(UserEntity user, String action, Map<String, String> form) {
        if ("yes".equals(action)) {
            user.setActive(!user.isActive());
        }

        Set<Role> newRoles = new HashSet<>();
        for (String key : form.keySet()) {
            if (Role.getStringRoles().contains(key)) {
                newRoles.add(Role.valueOf(key));

            }
        }
        if(user.getRoles().contains(Role.ADMIN)){
            user.setAdmin(true);
        }

        user.setRoles(newRoles);

        saveUser(user);
    }

    public void addRole(UserEntity user, Role role){
        user.getRoles().add(role);
        userRepository.addRoleToUser(user.getId(), role.name());
    }

    public boolean hasRole(UserEntity user, Role userRole){
        for (Role role : user.getRoles()){
            if (role.equals(userRole)){
                return true;
            }
        }
        return false;
    }
}
