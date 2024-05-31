package ru.kpfu.itis.springbootsemestrovka.dto.req;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@Builder
public class UserInfoRequest {

    private String firstName;
    private String lastName;
    private String gender;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date birthday;
    private String email;
    private String phone;

}
