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
@Table(name = "account_info")
public class UserInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String gender;
    private Date birthday;
    private String email;
    private String phone;

    @OneToOne
    @JoinColumn(name = "account_id")
    private UserEntity user;

}
