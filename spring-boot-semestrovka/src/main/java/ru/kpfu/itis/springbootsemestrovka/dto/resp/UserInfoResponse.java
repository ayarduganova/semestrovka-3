package ru.kpfu.itis.springbootsemestrovka.dto.resp;

import lombok.Builder;

import java.util.Date;

@Builder
public record UserInfoResponse(String firstName, String lastName, String gender,
                           Date birthday, String email, String phone) {
}
