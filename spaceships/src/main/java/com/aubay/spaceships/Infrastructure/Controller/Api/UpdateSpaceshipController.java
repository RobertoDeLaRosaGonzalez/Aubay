package com.aubay.spaceships.Infrastructure.Controller.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aubay.spaceships.Application.Command.UpdateSpaceship.UpdateSpaceship;
import com.aubay.spaceships.Application.Command.UpdateSpaceship.UpdateSpaceshipRequest;
import com.aubay.spaceships.Application.Command.UpdateSpaceship.UpdateSpaceshipResponse;
import com.aubay.spaceships.Domain.SpaceshipRepositoryInterface;

@RestController
public class UpdateSpaceshipController {
    @Autowired
    SpaceshipRepositoryInterface spaceshipRepositoryInterface;

    @PutMapping("/updateSpaceship")
    public ResponseEntity<?> updateSpaceship(@RequestBody UpdateSpaceshipRequest updateSpaceshipRequest) {
        UpdateSpaceship updateSpaceship = new UpdateSpaceship(spaceshipRepositoryInterface);
        UpdateSpaceshipResponse updateSpaceshipResponse = updateSpaceship.handle(updateSpaceshipRequest);
        return new ResponseEntity<>(updateSpaceshipResponse, HttpStatus.OK);
    }
}