package ru.kpfu.itis.springbootsemestrovka.dto.resp;

import lombok.Builder;

@Builder
public record WalkerFormResponse(Long id, String firstName, String lastName, String email, String phone) {
}
