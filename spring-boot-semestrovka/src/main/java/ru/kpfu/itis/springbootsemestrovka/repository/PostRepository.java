package ru.kpfu.itis.springbootsemestrovka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.springbootsemestrovka.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

}
