package ru.kpfu.itis.springbootsemestrovka.security.user;

import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public enum Role implements GrantedAuthority {
    USER,
    ADMIN,
    WALKER;

    @Override
    public String getAuthority() {
        return name();
    }

    public static Set<String> getStringRoles(){
        return Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());
    }
}
