package ru.kpfu.itis.springbootsemestrovka.security.user;

import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public enum Role  {
    USER,
    ADMIN,
    WALKER;

    public static Set<String> getStringRoles(){
        return Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());
    }
}
