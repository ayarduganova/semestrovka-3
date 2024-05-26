package ru.kpfu.itis.springbootsemestrovka.dto.resp;

import lombok.Builder;

@Builder
public record WalkerResponse(Integer workExperience, Double price, String aboutMe) {
}
