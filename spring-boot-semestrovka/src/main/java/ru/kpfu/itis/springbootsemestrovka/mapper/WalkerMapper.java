package ru.kpfu.itis.springbootsemestrovka.mapper;

import org.springframework.stereotype.Component;
import ru.kpfu.itis.springbootsemestrovka.dto.req.WalkerRequest;
import ru.kpfu.itis.springbootsemestrovka.dto.resp.WalkerResponse;
import ru.kpfu.itis.springbootsemestrovka.entity.WalkerEntity;

@Component
public class WalkerMapper implements StandartMapper<WalkerRequest, WalkerEntity>{

    @Override
    public WalkerEntity toEntity(WalkerRequest walkerRequest) {
        return WalkerEntity.builder()
                .price(walkerRequest.price())
                .aboutMe(walkerRequest.aboutMe())
                .workExperience(walkerRequest.workExperience())
                .build();
    }

    @Override
    public WalkerEntity updateEntityFromRequest(WalkerRequest walkerRequest, WalkerEntity walkerEntity) {
        walkerEntity.setPrice(walkerRequest.price());
        walkerEntity.setAboutMe(walkerRequest.aboutMe());
        walkerEntity.setWorkExperience(walkerRequest.workExperience());
        return walkerEntity;
    }

    public WalkerResponse toResponse(WalkerEntity walkerEntity) {
        return WalkerResponse.builder()
                .price(walkerEntity.getPrice())
                .aboutMe(walkerEntity.getAboutMe())
                .workExperience(walkerEntity.getWorkExperience())
                .build();
    }

}
