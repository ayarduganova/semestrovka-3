package ru.kpfu.itis.springbootsemestrovka.exception;

public class WalkerFormNotFoundServiceException extends NotFoundServiceException {
    public WalkerFormNotFoundServiceException(Long id) {
        super("WalkerForm with id = %s - not found".formatted(id));
    }
}
