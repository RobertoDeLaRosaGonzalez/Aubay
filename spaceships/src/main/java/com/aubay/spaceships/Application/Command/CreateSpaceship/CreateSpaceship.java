package com.aubay.spaceships.Application.Command.CreateSpaceship;

import org.springframework.beans.factory.annotation.Autowired;

import com.aubay.spaceships.Domain.Spaceship;
import com.aubay.spaceships.Domain.SpaceshipRepositoryInterface;

public class CreateSpaceship {
    @Autowired
    private SpaceshipRepositoryInterface spaceshipRepository;

    public CreateSpaceship(SpaceshipRepositoryInterface spaceshipRepository) {
        this.spaceshipRepository = spaceshipRepository;
    }

    public void handle(CreateSpaceshipRequest createSpaceshipRequest) {
        Spaceship spaceship = new Spaceship(createSpaceshipRequest.getName(), createSpaceshipRequest.getDescription());
        this.spaceshipRepository.save(spaceship);
    }

}
