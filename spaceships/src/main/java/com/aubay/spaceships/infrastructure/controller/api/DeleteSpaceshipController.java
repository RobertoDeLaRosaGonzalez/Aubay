package com.aubay.spaceships.infrastructure.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aubay.spaceships.application.command.deletespaceship.DeleteSpaceship;
import com.aubay.spaceships.application.command.deletespaceship.DeleteSpaceshipRequest;
import com.aubay.spaceships.domain.SpaceshipRepositoryInterface;

@RestController
public class DeleteSpaceshipController {
    @Autowired
    SpaceshipRepositoryInterface spaceshipRepositoryInterface;

    @CacheEvict(value = "spaceships", allEntries = true)
    @DeleteMapping("/spaceship/{id}")
    public ResponseEntity<?> deleteSpaceship(@PathVariable Long id) {
        DeleteSpaceshipRequest deleteSpaceshipRequest = new DeleteSpaceshipRequest(id);
        DeleteSpaceship deleteSpaceship = new DeleteSpaceship(spaceshipRepositoryInterface);
        deleteSpaceship.handle(deleteSpaceshipRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}