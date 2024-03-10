package com.aubay.spaceships.Infrastructure.Controller.Api;

import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aubay.spaceships.Application.Command.GetSpaceship.GetSpaceship;
import com.aubay.spaceships.Application.Command.GetSpaceship.GetSpaceshipRequest;
import com.aubay.spaceships.Application.Command.GetSpaceship.GetSpaceshipsRequest;
import com.aubay.spaceships.Domain.Spaceship;
import com.aubay.spaceships.Domain.SpaceshipRepositoryInterface;

@RestController
public class GetSpaceshipController {
    @Autowired
    SpaceshipRepositoryInterface spaceshipRepositoryInterface;

    @GetMapping("/getSpaceship/{spaceshipId}")
    public ResponseEntity<?> getSpaceship(@PathVariable("spaceshipId") Long id) {
        GetSpaceshipRequest getSpaceshipRequest = new GetSpaceshipRequest(id);
        GetSpaceship getSpaceship = new GetSpaceship(spaceshipRepositoryInterface);
        /*Optional<Spaceship> spaceship = getSpaceship.handle(getSpaceshipRequest);
        if (spaceship.isPresent()){
            JSONObject json = new JSONObject(spaceship);
            return new ResponseEntity<JSONObject>(json, HttpStatus.OK);
        } */

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getSpaceships")
    public ResponseEntity<?> getSpaceships(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "3") Integer size) {
        GetSpaceshipsRequest getSpaceshipsRequest = new GetSpaceshipsRequest(page, size);
        GetSpaceship getSpaceship = new GetSpaceship(spaceshipRepositoryInterface);
        Page<Spaceship> spaceships = getSpaceship.handle(getSpaceshipsRequest);
        //JSONObject json = new JSONObject(spaceships);
        return new ResponseEntity<>(spaceships, HttpStatus.OK);
    }
}