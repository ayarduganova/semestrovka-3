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
@Table(name = "post")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private String comment;

}
