package com.aubay.spaceships.Application.Command.CreateSpaceship;

import com.aubay.spaceships.Domain.Spaceship;

public class CreateSpaceshipResponse {
	
	Long id;
    String name;
    String description;
    
    public Long getId() {
    	return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public CreateSpaceshipResponse(Spaceship spaceship) {
    	this.id = spaceship.getId();
        this.name = spaceship.getName();
        this.description = spaceship.getDescription();
    }
    
}
