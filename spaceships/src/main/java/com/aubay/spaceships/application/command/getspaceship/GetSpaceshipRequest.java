package com.aubay.spaceships.application.command.getspaceship;

public class GetSpaceshipRequest {

    Long id;

    public Long getId() {
        return id;
    }

    public GetSpaceshipRequest(Long id) {
        this.id = id;
    }
}