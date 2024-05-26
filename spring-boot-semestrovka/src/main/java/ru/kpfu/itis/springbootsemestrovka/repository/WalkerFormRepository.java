package ru.kpfu.itis.springbootsemestrovka.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.springbootsemestrovka.entity.WalkerFormEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface WalkerFormRepository extends JpaRepository<WalkerFormEntity, UUID> {

    Optional<WalkerFormEntity> getWalkerFormEntityById(Long id);

    @Query("SELECT w FROM WalkerFormEntity w WHERE w.isChecked = false")
    List<WalkerFormEntity> getAllUnCheckedForms();

    @Modifying
    @Transactional
    @Query("UPDATE WalkerFormEntity w SET w.isChecked = true WHERE w.id = :id")
    void updateCheckedField(Long id);

}
