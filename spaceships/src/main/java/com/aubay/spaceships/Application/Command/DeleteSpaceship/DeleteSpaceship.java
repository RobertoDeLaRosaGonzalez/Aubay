package com.aubay.spaceships.Application.Command.DeleteSpaceship;

import org.springframework.beans.factory.annotation.Autowired;

import com.aubay.spaceships.Domain.SpaceshipRepositoryInterface;

public class DeleteSpaceship {
    @Autowired
    private SpaceshipRepositoryInterface spaceshipRepository;

    public DeleteSpaceship(SpaceshipRepositoryInterface spaceshipRepository) {
        this.spaceshipRepository = spaceshipRepository;
    }

    public void handle(DeleteSpaceshipRequest deleteSpaceshipRequest) {
        this.spaceshipRepository.deleteById(deleteSpaceshipRequest.getId());
    }

}