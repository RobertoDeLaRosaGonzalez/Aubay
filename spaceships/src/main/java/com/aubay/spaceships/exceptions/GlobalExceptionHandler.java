package com.aubay.spaceships.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.aubay.spaceships.domain.exceptions.NoSuchSpaceshipFoundException;
import com.aubay.spaceships.domain.exceptions.SpaceshipAlreadyExistsException;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(NoSuchSpaceshipFoundException.class)
    public ResponseEntity<String> handleNoSuchSpaceshipFoundException(NoSuchSpaceshipFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(SpaceshipAlreadyExistsException.class)
    public ResponseEntity<String> handleSpaceshipAlreadyExistsException(SpaceshipAlreadyExistsException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }
}