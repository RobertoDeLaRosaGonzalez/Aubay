package com.aubay.spaceships.application.command.createspaceship;

import org.springframework.beans.factory.annotation.Autowired;

import com.aubay.spaceships.domain.Spaceship;
import com.aubay.spaceships.domain.SpaceshipRepositoryInterface;

public class CreateSpaceship {
    @Autowired
    private SpaceshipRepositoryInterface spaceshipRepository;

    public CreateSpaceship(SpaceshipRepositoryInterface spaceshipRepository) {
        this.spaceshipRepository = spaceshipRepository;
    }

    public CreateSpaceshipResponse handle(CreateSpaceshipRequest createSpaceshipRequest) {
        Spaceship spaceship = new Spaceship(createSpaceshipRequest.getName(), createSpaceshipRequest.getDescription());
        spaceship = this.spaceshipRepository.save(spaceship);
        CreateSpaceshipResponse createSpaceshipResponse = new CreateSpaceshipResponse(spaceship);
        
        return createSpaceshipResponse;
    }

}
