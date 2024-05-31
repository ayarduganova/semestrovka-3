package ru.kpfu.itis.springbootsemestrovka.exception;

public class DogNotFoundServiceException extends NotFoundServiceException {
    public DogNotFoundServiceException(Long id) {
        super("Dog with id = %s - not found".formatted(id));
    }
}
