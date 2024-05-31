package ru.kpfu.itis.springbootsemestrovka.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.kpfu.itis.springbootsemestrovka.security.user.Role;

import java.util.List;
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<RoleEntity> roles;

    private boolean isActive;

    private boolean isAdmin;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserInfoEntity userInfoEntity;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private WalkerEntity walkerEntity;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<DogEntity> dogs;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PostEntity> posts;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<WalkerFormEntity> walkerFormEntities;
}
