package ru.kpfu.itis.springbootsemestrovka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.springbootsemestrovka.entity.UserEntity;
import ru.kpfu.itis.springbootsemestrovka.entity.UserInfoEntity;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Long> {

    Optional<UserInfoEntity> getUserInfoEntityById(Long id);

    Optional<UserInfoEntity> getUserInfoEntityByUser(UserEntity user);

}
