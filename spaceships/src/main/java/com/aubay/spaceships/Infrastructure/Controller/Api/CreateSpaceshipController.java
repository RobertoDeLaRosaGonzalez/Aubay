package com.aubay.spaceships.Infrastructure.Controller.Api;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.aubay.spaceships.Application.Command.CreateSpaceship.CreateSpaceship;
import com.aubay.spaceships.Application.Command.CreateSpaceship.CreateSpaceshipRequest;
import com.aubay.spaceships.Application.Command.CreateSpaceship.CreateSpaceshipResponse;
import com.aubay.spaceships.Domain.Spaceship;
import com.aubay.spaceships.Domain.SpaceshipRepositoryInterface;

@RestController
public class CreateSpaceshipController {
    @Autowired
    SpaceshipRepositoryInterface spaceshipRepositoryInterface;

    @PostMapping("/spaceship")
    public ResponseEntity<?> addNewSpaceship (@RequestBody CreateSpaceshipRequest createSpaceshipRequest) {
    	
        CreateSpaceship createSpaceship = new CreateSpaceship(spaceshipRepositoryInterface);
        CreateSpaceshipResponse createSpaceshipResponse = createSpaceship.handle(createSpaceshipRequest);
        return new ResponseEntity<>(createSpaceshipResponse, HttpStatus.CREATED);
    }
}
