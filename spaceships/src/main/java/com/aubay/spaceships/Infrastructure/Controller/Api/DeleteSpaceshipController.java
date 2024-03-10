package com.aubay.spaceships.Infrastructure.Controller.Api;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aubay.spaceships.Application.Command.DeleteSpaceship.DeleteSpaceship;
import com.aubay.spaceships.Application.Command.DeleteSpaceship.DeleteSpaceshipRequest;
import com.aubay.spaceships.Domain.SpaceshipRepositoryInterface;

@RestController
public class DeleteSpaceshipController {
    @Autowired
    SpaceshipRepositoryInterface spaceshipRepositoryInterface;

    @DeleteMapping("/spaceship/{id}")
    public ResponseEntity<?> deleteSpaceship(@PathVariable Long id) {
        DeleteSpaceshipRequest deleteSpaceshipRequest = new DeleteSpaceshipRequest(id);
        DeleteSpaceship deleteSpaceship = new DeleteSpaceship(spaceshipRepositoryInterface);
        deleteSpaceship.handle(deleteSpaceshipRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}