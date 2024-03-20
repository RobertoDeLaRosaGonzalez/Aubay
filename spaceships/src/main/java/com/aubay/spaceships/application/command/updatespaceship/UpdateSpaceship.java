package com.aubay.spaceships.application.command.updatespaceship;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.aubay.spaceships.application.command.getspaceship.GetSpaceship;
import com.aubay.spaceships.application.command.getspaceship.GetSpaceshipRequest;
import com.aubay.spaceships.application.command.getspaceship.GetSpaceshipResponse;
import com.aubay.spaceships.domain.Spaceship;
import com.aubay.spaceships.domain.SpaceshipRepositoryInterface;
import com.aubay.spaceships.domain.exceptions.SpaceshipAlreadyExistsException;

public class UpdateSpaceship {
    @Autowired
    private SpaceshipRepositoryInterface spaceshipRepository;

    public UpdateSpaceship(SpaceshipRepositoryInterface spaceshipRepository) {
        this.spaceshipRepository = spaceshipRepository;
    }

    public UpdateSpaceshipResponse handle(UpdateSpaceshipRequest updateSpaceshipRequest) {
    	GetSpaceshipRequest getSpaceshipRequest = new GetSpaceshipRequest(updateSpaceshipRequest.getId());
        GetSpaceship getSpaceship = new GetSpaceship(spaceshipRepository);
        GetSpaceshipResponse SpaceshipResponse = getSpaceship.handle(getSpaceshipRequest);
        
        Optional<Spaceship> existingByName = this.spaceshipRepository.findByName(updateSpaceshipRequest.getName());
        if (existingByName.isPresent() && !existingByName.get().getId().equals(updateSpaceshipRequest.getId())) {
        	throw new SpaceshipAlreadyExistsException("A Spaceship with name: " + updateSpaceshipRequest.getName() + " already exists.");
        }
        
        Spaceship spaceship = new Spaceship(updateSpaceshipRequest.getId(), updateSpaceshipRequest.getName(), updateSpaceshipRequest.getDescription());
        this.spaceshipRepository.save(spaceship);
        UpdateSpaceshipResponse updateSpaceshipResponse = new UpdateSpaceshipResponse(spaceship);
        return updateSpaceshipResponse;
    }

}