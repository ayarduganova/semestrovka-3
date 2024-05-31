package ru.kpfu.itis.springbootsemestrovka.dto.req;

import lombok.Builder;

@Builder
public record UserSignUpRequest(String username, String password) {
}
