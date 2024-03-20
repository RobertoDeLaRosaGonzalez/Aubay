package com.aubay.spaceships.application.command.createspaceship;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.aubay.spaceships.domain.Spaceship;
import com.aubay.spaceships.domain.SpaceshipRepositoryInterface;
import com.aubay.spaceships.domain.exceptions.SpaceshipAlreadyExistsException;

public class CreateSpaceship {
    @Autowired
    private SpaceshipRepositoryInterface spaceshipRepository;

    public CreateSpaceship(SpaceshipRepositoryInterface spaceshipRepository) {
        this.spaceshipRepository = spaceshipRepository;
    }

    public CreateSpaceshipResponse handle(CreateSpaceshipRequest createSpaceshipRequest) {
    	
    	Optional<Spaceship> spaceship = this.spaceshipRepository.findByName(createSpaceshipRequest.getName());
        if(spaceship.isPresent())
        {
        	throw new SpaceshipAlreadyExistsException("A Spaceship with name: " + createSpaceshipRequest.getName() + " already exists.");
        }
        
        Spaceship newSpaceship = new Spaceship(createSpaceshipRequest.getName(), createSpaceshipRequest.getDescription());
        newSpaceship = this.spaceshipRepository.save(newSpaceship);
        CreateSpaceshipResponse createSpaceshipResponse = new CreateSpaceshipResponse(newSpaceship);
        
        return createSpaceshipResponse;
    }

}
