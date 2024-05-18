package ru.kpfu.itis.springbootsemestrovka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.springbootsemestrovka.entity.DogEntity;
import ru.kpfu.itis.springbootsemestrovka.entity.UserEntity;

import java.util.List;

@Repository
public interface DogRepository extends JpaRepository<DogEntity, Long> {

    List<DogEntity> getDogEntitiesByUser(UserEntity user);

}
