package ru.kpfu.itis.springbootsemestrovka.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.kpfu.itis.springbootsemestrovka.dto.UserRequest;
import ru.kpfu.itis.springbootsemestrovka.entity.UserEntity;

@Mapper
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    UserEntity toEntity(UserRequest userRequest);

}

