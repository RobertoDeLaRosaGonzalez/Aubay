package com.aubay.spaceships.application.command.getspaceship;

public class GetSpaceshipContainingNameRequest {

    String name;

    public String getName() {
        return name;
    }

    public GetSpaceshipContainingNameRequest(String name) {
        this.name = name;
    }
}