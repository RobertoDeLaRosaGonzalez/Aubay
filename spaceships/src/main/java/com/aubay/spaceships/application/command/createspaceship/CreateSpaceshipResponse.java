package com.aubay.spaceships.application.command.createspaceship;

import com.aubay.spaceships.domain.Spaceship;

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
