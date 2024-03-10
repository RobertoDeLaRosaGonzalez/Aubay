package com.aubay.spaceships.Application.Command.UpdateSpaceship;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.aubay.spaceships.Application.Command.GetSpaceship.GetSpaceship;
import com.aubay.spaceships.Application.Command.GetSpaceship.GetSpaceshipRequest;
import com.aubay.spaceships.Domain.Spaceship;
import com.aubay.spaceships.Domain.SpaceshipRepositoryInterface;

public class UpdateSpaceship {
    @Autowired
    private SpaceshipRepositoryInterface spaceshipRepository;

    public UpdateSpaceship(SpaceshipRepositoryInterface spaceshipRepository) {
        this.spaceshipRepository = spaceshipRepository;
    }

    public UpdateSpaceshipResponse handle(UpdateSpaceshipRequest updateSpaceshipRequest) {
    	GetSpaceshipRequest getSpaceshipRequest = new GetSpaceshipRequest(updateSpaceshipRequest.getId());
        GetSpaceship getSpaceship = new GetSpaceship(spaceshipRepository);
        Spaceship spaceship = getSpaceship.handle(getSpaceshipRequest);
        
        spaceship = new Spaceship(updateSpaceshipRequest.getId(), updateSpaceshipRequest.getName(), updateSpaceshipRequest.getDescription());
        this.spaceshipRepository.save(spaceship);
        UpdateSpaceshipResponse updateSpaceshipResponse = new UpdateSpaceshipResponse(spaceship);
        return updateSpaceshipResponse;
    }

}