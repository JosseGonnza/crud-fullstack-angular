package com.jossegonnza.crudfullstackangular.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice //Va ha hacer de interceptor entre cliente y backend
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class) //Es un interceptor, todas las excepciones pasaran por esta clase
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException ex,
                                                                        WebRequest webRequest){
        ErrorDetails error = new ErrorDetails (
                LocalDateTime.now(),
                ex.getMessage(),
                webRequest.getDescription(false),
                "NOT FOUND"
                );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
