package ru.kpfu.itis.springbootsemestrovka.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.springbootsemestrovka.dto.req.UserSignUpRequest;
import ru.kpfu.itis.springbootsemestrovka.dto.resp.UserResponse;
import ru.kpfu.itis.springbootsemestrovka.entity.RoleEntity;
import ru.kpfu.itis.springbootsemestrovka.entity.UserEntity;
import ru.kpfu.itis.springbootsemestrovka.mapper.RoleMapper;
import ru.kpfu.itis.springbootsemestrovka.mapper.UserMapper;
import ru.kpfu.itis.springbootsemestrovka.repository.UserRepository;
import ru.kpfu.itis.springbootsemestrovka.security.user.Role;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final UserMapper userMapper;
    private final RoleMapper roleMapper;

    public UserEntity signUp(UserSignUpRequest userRequest) {
        return userRepository.save(userMapper.toEntity(userRequest));
    }

    public boolean exist(String username){
        return userRepository.existsByUsername(username);
    }

    public List<UserResponse> getAll(){
        return userMapper.toListResponse(userRepository.findAll());
    }

    public void saveUser(UserEntity userEntity){
        userRepository.save(userEntity);
    }

    public void editUser(UserEntity user, String blockAction, Map<String, String> form, String btnAction) {

        if(btnAction.equals("delete")){
            deleteUser(user);
        }
        else {
            if ("yes".equals(blockAction)) {
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

            user.setRoles(roleMapper.toListRoleEntity(newRoles));

            saveUser(user);
        }
    }

    public void addRole(UserEntity user, Role role){
        user.getRoles().add(roleMapper.toEntity(role));
        userRepository.addRoleToUser(user.getId(), role.name());
    }

    public boolean hasWalkerRole(UserEntity user){
        for (RoleEntity role : user.getRoles()){
            if (role.getRole().equals(Role.WALKER)){
                return true;
            }
        }
        return false;
    }


    private void deleteUser(UserEntity user){
        userRepository.delete(user);
    }

}
