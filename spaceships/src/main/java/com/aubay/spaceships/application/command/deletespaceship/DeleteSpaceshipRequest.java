package com.aubay.spaceships.application.command.deletespaceship;

public class DeleteSpaceshipRequest {

    Long id;

    public Long getId() {
        return id;
    }

    public DeleteSpaceshipRequest(Long id) {
        this.id = id;
    }
}