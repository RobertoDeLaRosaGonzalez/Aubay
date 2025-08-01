package com.aubay.spaceships.infrastructure.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aubay.spaceships.application.command.getspaceship.GetSpaceship;
import com.aubay.spaceships.application.command.getspaceship.GetSpaceshipContainingNameRequest;
import com.aubay.spaceships.application.command.getspaceship.GetSpaceshipRequest;
import com.aubay.spaceships.application.command.getspaceship.GetSpaceshipResponse;
import com.aubay.spaceships.application.command.getspaceship.GetSpaceshipsRequest;
import com.aubay.spaceships.application.command.getspaceship.GetSpaceshipsResponse;
import com.aubay.spaceships.domain.Spaceship;
import com.aubay.spaceships.domain.SpaceshipRepositoryInterface;

@RestController
public class GetSpaceshipController {
    @Autowired
    SpaceshipRepositoryInterface spaceshipRepositoryInterface;
    
    @Cacheable(value = "spaceships", key = "#spaceshipId")
    @GetMapping("/getSpaceship/{spaceshipId}")
    public ResponseEntity<?> getSpaceship(@PathVariable("spaceshipId") Long spaceshipId) {
        GetSpaceshipRequest getSpaceshipRequest = new GetSpaceshipRequest(spaceshipId);
        GetSpaceship getSpaceship = new GetSpaceship(spaceshipRepositoryInterface);
        GetSpaceshipResponse spaceship = getSpaceship.handle(getSpaceshipRequest);
        return new ResponseEntity<>(spaceship, HttpStatus.OK);
    }
    
    @Cacheable(value = "spaceships", key = "#name")
    @GetMapping("/getSpaceship/byName/{name}")
    public ResponseEntity<?> getSpaceship(@PathVariable("name") String name) {
    	GetSpaceshipContainingNameRequest getSpaceshipContainingNameRequest = new GetSpaceshipContainingNameRequest(name);
        GetSpaceship getSpaceship = new GetSpaceship(spaceshipRepositoryInterface);
        GetSpaceshipsResponse spaceships = getSpaceship.handleByName(getSpaceshipContainingNameRequest);
        return new ResponseEntity<>(spaceships, HttpStatus.OK);
    }

    @Cacheable(value = "spaceships")
    @GetMapping("/getSpaceships")
    public ResponseEntity<?> getSpaceships(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "3") Integer size) {
        GetSpaceshipsRequest getSpaceshipsRequest = new GetSpaceshipsRequest(page, size);
        GetSpaceship getSpaceship = new GetSpaceship(spaceshipRepositoryInterface);
        Page<Spaceship> spaceships = getSpaceship.handle(getSpaceshipsRequest);
        return new ResponseEntity<>(spaceships, HttpStatus.OK);
    }
}