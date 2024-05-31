package ru.kpfu.itis.springbootsemestrovka.dto.req;

import lombok.Builder;

@Builder
public record PostRequest(String comment) {
}
