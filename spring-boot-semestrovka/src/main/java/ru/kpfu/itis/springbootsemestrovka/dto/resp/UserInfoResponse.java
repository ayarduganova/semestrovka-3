package ru.kpfu.itis.springbootsemestrovka.dto.resp;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
public class UserInfoResponse {
    private String firstName;
    private String lastName;
    private String gender;
    private Date birthday;
    private String email;
    private String phone;
}
