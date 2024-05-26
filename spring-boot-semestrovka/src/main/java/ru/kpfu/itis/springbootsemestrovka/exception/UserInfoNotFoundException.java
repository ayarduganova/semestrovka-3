package ru.kpfu.itis.springbootsemestrovka.exception;

public class UserInfoNotFoundException extends NotFoundServiceException{

    public UserInfoNotFoundException(Long id) {
        super("InfoUser with id = %s - not found".formatted(id));
    }

}
