package ru.kpfu.itis.springbootsemestrovka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.springbootsemestrovka.entity.UserEntity;
import ru.kpfu.itis.springbootsemestrovka.entity.WalkerEntity;

import java.util.Optional;

@Repository
public interface WalkerRepository extends JpaRepository<WalkerEntity, Long> {

    Optional<WalkerEntity> getWalkerEntityByUser(UserEntity user);

}
