package ru.kpfu.itis.springbootsemestrovka.exception;

import java.util.UUID;

public class UserInfoNotFoundException extends NotFoundServiceException{

    public UserInfoNotFoundException(Long id) {
        super("InfoUser with id = %s - not found".formatted(id));
    }

}
