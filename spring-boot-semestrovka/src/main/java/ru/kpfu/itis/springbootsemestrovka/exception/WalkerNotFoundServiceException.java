package ru.kpfu.itis.springbootsemestrovka.exception;

public class WalkerNotFoundServiceException extends NotFoundServiceException {
    public WalkerNotFoundServiceException(Long id) {
        super("Walker by userId = %s - not found".formatted(id));
    }
}
