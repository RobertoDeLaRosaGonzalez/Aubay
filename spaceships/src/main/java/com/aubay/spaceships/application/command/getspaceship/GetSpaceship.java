package com.aubay.spaceships.application.command.getspaceship;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.aubay.spaceships.domain.Spaceship;
import com.aubay.spaceships.domain.SpaceshipRepositoryInterface;
import com.aubay.spaceships.domain.exceptions.NoSuchSpaceshipFoundException;

public class GetSpaceship {
    @Autowired
    private SpaceshipRepositoryInterface spaceshipRepository;

    public GetSpaceship(SpaceshipRepositoryInterface spaceshipRepository) {
        this.spaceshipRepository = spaceshipRepository;
    }

    public GetSpaceshipResponse handle(GetSpaceshipRequest getSpaceshipRequest) {
        Optional<Spaceship> spaceship = this.spaceshipRepository.findById(getSpaceshipRequest.getId());
        if(!spaceship.isPresent())
        {
        	throw new NoSuchSpaceshipFoundException("There is no spaceship with the id: " + getSpaceshipRequest.getId());
        }
        return new GetSpaceshipResponse(spaceship.get());
    }

    public Page<Spaceship> handle(GetSpaceshipsRequest getSpaceshipsRequest) {
        Pageable pageRequested = PageRequest.of(getSpaceshipsRequest.getPage(), getSpaceshipsRequest.getSize());
        Page<Spaceship> spaceships = this.spaceshipRepository.findAll(pageRequested);
        return spaceships;
    }

    public GetSpaceshipsResponse handleByName(GetSpaceshipContainingNameRequest getSpaceshipContainingNameRequest) {
        List<Spaceship> spaceships = this.spaceshipRepository.findByNameContaining(getSpaceshipContainingNameRequest.getName());
        return new GetSpaceshipsResponse(spaceships);
    }
}