package com.aubay.spaceships.Application.Command.GetSpaceship;

public class GetSpaceshipContainingNameRequest {

    String name;

    public String getName() {
        return name;
    }

    public GetSpaceshipContainingNameRequest(String name) {
        this.name = name;
    }
}