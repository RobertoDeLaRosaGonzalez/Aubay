package com.aubay.spaceships.application.command.createspaceship;

public class CreateSpaceshipRequest {
    
    String name;
    String description;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public CreateSpaceshipRequest(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
