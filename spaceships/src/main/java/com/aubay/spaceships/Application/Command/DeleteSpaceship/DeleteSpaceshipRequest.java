package com.aubay.spaceships.Application.Command.DeleteSpaceship;

public class DeleteSpaceshipRequest {

    Long id;

    public Long getId() {
        return id;
    }

    public DeleteSpaceshipRequest(Long id) {
        this.id = id;
    }
}