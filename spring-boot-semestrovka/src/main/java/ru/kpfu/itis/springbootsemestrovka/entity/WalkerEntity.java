package ru.kpfu.itis.springbootsemestrovka.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "walker")
public class WalkerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "work_experience")
    private Integer workExperience;

    private Double price;

    @Column(name = "about_me")
    private String aboutMe;

    @OneToOne
    @JoinColumn(name = "account_id")
    private UserEntity user;

}
