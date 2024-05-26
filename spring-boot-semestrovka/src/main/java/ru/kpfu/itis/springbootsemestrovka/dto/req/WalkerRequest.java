package ru.kpfu.itis.springbootsemestrovka.dto.req;

import lombok.Builder;

@Builder
public record WalkerRequest(Integer workExperience, Double price, String aboutMe) {
}
