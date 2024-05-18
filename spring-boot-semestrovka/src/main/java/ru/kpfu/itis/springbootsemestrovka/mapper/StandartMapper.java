package ru.kpfu.itis.springbootsemestrovka.mapper;

public interface StandartMapper<T, U> {

    U toEntity(T t);

    U updateEntityFromRequest(T t, U u);
}
