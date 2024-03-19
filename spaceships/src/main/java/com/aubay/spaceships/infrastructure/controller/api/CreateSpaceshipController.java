package com.aubay.spaceships.infrastructure.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aubay.spaceships.application.command.createspaceship.CreateSpaceship;
import com.aubay.spaceships.application.command.createspaceship.CreateSpaceshipRequest;
import com.aubay.spaceships.application.command.createspaceship.CreateSpaceshipResponse;
import com.aubay.spaceships.domain.SpaceshipRepositoryInterface;

@RestController
public class CreateSpaceshipController {
    @Autowired
    SpaceshipRepositoryInterface spaceshipRepositoryInterface;
    
    @CacheEvict(value = "spaceships", allEntries = true)
    @PostMapping("/spaceship")
    public ResponseEntity<?> addNewSpaceship (@RequestBody CreateSpaceshipRequest createSpaceshipRequest) {
    	
        CreateSpaceship createSpaceship = new CreateSpaceship(spaceshipRepositoryInterface);
        CreateSpaceshipResponse createSpaceshipResponse = createSpaceship.handle(createSpaceshipRequest);
        return new ResponseEntity<>(createSpaceshipResponse, HttpStatus.CREATED);
    }
}
