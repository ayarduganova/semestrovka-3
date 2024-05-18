package ru.kpfu.itis.springbootsemestrovka.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dog")
public class DogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    private String breed;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
