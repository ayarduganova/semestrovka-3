package ru.kpfu.itis.springbootsemestrovka.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.kpfu.itis.springbootsemestrovka.security.user.Role;

import java.util.Set;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "account")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    private boolean isActive;

}
