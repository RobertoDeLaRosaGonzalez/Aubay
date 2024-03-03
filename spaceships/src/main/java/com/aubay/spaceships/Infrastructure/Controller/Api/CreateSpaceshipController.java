package com.aubay.spaceships.Infrastructure.Controller.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aubay.spaceships.Application.Command.CreateSpaceship.CreateSpaceship;
import com.aubay.spaceships.Application.Command.CreateSpaceship.CreateSpaceshipRequest;
import com.aubay.spaceships.Domain.SpaceshipRepositoryInterface;

@RestController
public class CreateSpaceshipController {
    @Autowired
    SpaceshipRepositoryInterface spaceshipRepositoryInterface;

    @PostMapping("/spaceship")
    public @ResponseBody String addNewSpaceship (@RequestParam String name
    , @RequestParam String description) {
        CreateSpaceshipRequest createSpaceshipRequest = new CreateSpaceshipRequest(name, description);
        CreateSpaceship createSpaceship = new CreateSpaceship(spaceshipRepositoryInterface);
        createSpaceship.handle(createSpaceshipRequest);
        return "Saved";
    }
}
