package com.aubay.spaceships.application.command.deletespaceship;

import org.springframework.beans.factory.annotation.Autowired;

import com.aubay.spaceships.domain.SpaceshipRepositoryInterface;

public class DeleteSpaceship {
    @Autowired
    private SpaceshipRepositoryInterface spaceshipRepository;

    public DeleteSpaceship(SpaceshipRepositoryInterface spaceshipRepository) {
        this.spaceshipRepository = spaceshipRepository;
    }

    public void handle(DeleteSpaceshipRequest deleteSpaceshipRequest) {
        this.spaceshipRepository.deleteById(deleteSpaceshipRequest.getId());
        System.out.println("borrando");
    }

}