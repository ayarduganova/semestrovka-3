package ru.kpfu.itis.springbootsemestrovka.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.kpfu.itis.springbootsemestrovka.exception.ServiceException;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public String handleServiceException(ServiceException ex) {
        log.error(ex.getMessage());
        return "exception/service_ex";
    }

//    @ExceptionHandler(ServiceException.class)
//    public final ResponseEntity<String> handleServiceException(ServiceException exception) {
//        return ResponseEntity.status(exception.getStatus())
//                .body(exception.getMessage());
//    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final String onAllExceptions(Exception exception) {
        log.error(exception.getMessage());
        return "exception/all_ex";
    }

//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public final String onAllExceptions(Exception exception) {
//        return exception.getMessage();
//    }

}
