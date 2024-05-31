package ru.kpfu.itis.springbootsemestrovka.exception;

public class UserInfoByUserNotFoundException extends NotFoundServiceException{

    public UserInfoByUserNotFoundException(Long id) {
        super("InfoUser by User with id = %s - not found".formatted(id));
    }
}
