package ru.kpfu.itis.springbootsemestrovka.dto.req;

import lombok.Getter;
import lombok.Setter;

public record UserSignUpRequest(String username, String password) {
}
