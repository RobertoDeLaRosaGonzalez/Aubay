package com.aubay.spaceships.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.aubay.spaceships.Domain.Exceptions.NoSuchSpaceshipFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(NoSuchSpaceshipFoundException.class)
    public ResponseEntity<String> handleNoSuchSpaceshipFoundException(NoSuchSpaceshipFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}