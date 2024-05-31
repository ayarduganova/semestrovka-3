package ru.kpfu.itis.springbootsemestrovka.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.springbootsemestrovka.entity.UserEntity;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> getUserEntityByUsername(String username);

    boolean existsByUsername(String username);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO user_role (user_id, roles) VALUES (:userId, :role)", nativeQuery = true)
    void addRoleToUser(Long userId, String role);

}
