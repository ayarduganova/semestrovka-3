package ru.kpfu.itis.springbootsemestrovka.dto.req;

import lombok.Builder;

@Builder
public record WalkerFormRequest(String firstName, String lastName, String email, String phone) {
}
