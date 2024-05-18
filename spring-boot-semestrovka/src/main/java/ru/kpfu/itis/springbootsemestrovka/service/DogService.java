package ru.kpfu.itis.springbootsemestrovka.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.springbootsemestrovka.dto.req.DogRequest;
import ru.kpfu.itis.springbootsemestrovka.entity.DogEntity;
import ru.kpfu.itis.springbootsemestrovka.entity.UserEntity;
import ru.kpfu.itis.springbootsemestrovka.mapper.DogMapper;
import ru.kpfu.itis.springbootsemestrovka.repository.DogRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DogService {

    private final DogRepository dogRepository;
    private final DogMapper dogMapper;

    public List<DogEntity> getDogs(UserEntity user) {
        return dogRepository.getDogEntitiesByUser(user);
    }

    public List<DogEntity> getAll() {
        return dogRepository.findAll();
    }

    public void editDog(DogEntity dogEntity, DogRequest dogRequest) {
        dogRepository.save(dogMapper.updateEntityFromRequest(dogRequest, dogEntity));
    }

    public void addDog(UserEntity user, DogRequest dogRequest) {
        DogEntity dogEntity = dogMapper.toEntity(dogRequest);
        dogEntity.setUser(user);
        dogRepository.save(dogEntity);
    }

}
