package ru.kpfu.itis.springbootsemestrovka.dto.resp;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PostResponse {
    private String comment;
    private UserInfoResponse userInfoResponse;
}
