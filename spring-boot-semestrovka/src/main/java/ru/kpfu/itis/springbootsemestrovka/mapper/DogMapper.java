package ru.kpfu.itis.springbootsemestrovka.mapper;

import org.springframework.stereotype.Component;
import ru.kpfu.itis.springbootsemestrovka.dto.req.DogRequest;
import ru.kpfu.itis.springbootsemestrovka.entity.DogEntity;

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
