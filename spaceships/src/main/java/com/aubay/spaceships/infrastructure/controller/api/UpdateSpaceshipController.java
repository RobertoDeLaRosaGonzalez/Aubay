package com.aubay.spaceships.infrastructure.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aubay.spaceships.application.command.updatespaceship.UpdateSpaceship;
import com.aubay.spaceships.application.command.updatespaceship.UpdateSpaceshipRequest;
import com.aubay.spaceships.application.command.updatespaceship.UpdateSpaceshipResponse;
import com.aubay.spaceships.domain.SpaceshipRepositoryInterface;

@RestController
public class UpdateSpaceshipController {
    @Autowired
    SpaceshipRepositoryInterface spaceshipRepositoryInterface;

    @CacheEvict(value = "spaceships", allEntries = true)
    @PutMapping("/updateSpaceship")
    public ResponseEntity<?> updateSpaceship(@RequestBody UpdateSpaceshipRequest updateSpaceshipRequest) {
        UpdateSpaceship updateSpaceship = new UpdateSpaceship(spaceshipRepositoryInterface);
        UpdateSpaceshipResponse updateSpaceshipResponse = updateSpaceship.handle(updateSpaceshipRequest);
        return new ResponseEntity<>(updateSpaceshipResponse, HttpStatus.OK);
    }
}