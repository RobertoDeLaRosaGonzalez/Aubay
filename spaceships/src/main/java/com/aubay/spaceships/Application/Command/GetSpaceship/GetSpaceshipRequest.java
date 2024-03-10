package com.aubay.spaceships.Application.Command.GetSpaceship;

public class GetSpaceshipRequest {

    Long id;

    public Long getId() {
        return id;
    }

    public GetSpaceshipRequest(Long id) {
        this.id = id;
    }
}