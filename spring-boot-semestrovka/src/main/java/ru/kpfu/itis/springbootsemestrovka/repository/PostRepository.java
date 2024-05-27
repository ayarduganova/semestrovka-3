package ru.kpfu.itis.springbootsemestrovka.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.springbootsemestrovka.entity.PostEntity;
import ru.kpfu.itis.springbootsemestrovka.entity.WalkerFormEntity;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

    @Query("select p from PostEntity p where p.comment like %:query% or" +
            " p.user.userInfoEntity.firstName like %:query% or p.user.userInfoEntity.lastName like %:query%")
    List<PostEntity> getPostLikeByQuery(String query);
}
