package ru.kpfu.itis.springbootsemestrovka.dto.resp;

import lombok.Builder;

@Builder
public record PostResponse(String comment, UserInfoResponse userInfoResponse) {
}
