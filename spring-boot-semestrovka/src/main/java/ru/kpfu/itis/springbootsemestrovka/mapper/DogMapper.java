package ru.kpfu.itis.springbootsemestrovka.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.springbootsemestrovka.dto.req.DogRequest;
import ru.kpfu.itis.springbootsemestrovka.dto.req.UserInfoRequest;
import ru.kpfu.itis.springbootsemestrovka.entity.DogEntity;
import ru.kpfu.itis.springbootsemestrovka.entity.UserInfoEntity;

@Component
public class DogMapper implements StandartMapper<DogRequest, DogEntity>{

    @Override
    public DogEntity toEntity(DogRequest dogRequest) {
        return DogEntity.builder()
                .name(dogRequest.name())
                .age(dogRequest.age())
                .breed(dogRequest.breed())
                .build();
    }

    @Override
    public DogEntity updateEntityFromRequest(DogRequest dogRequest, DogEntity dogEntity) {
        dogEntity.setAge(dogRequest.age());
        dogEntity.setName(dogRequest.name());
        dogEntity.setBreed(dogRequest.breed());
        return dogEntity;
    }

}
