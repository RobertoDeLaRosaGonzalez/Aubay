package com.aubay.spaceships.application.command.updatespaceship;

import com.aubay.spaceships.domain.Spaceship;

public class UpdateSpaceshipResponse {
	
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

    public UpdateSpaceshipResponse(Spaceship spaceship) {
    	this.id = spaceship.getId();
        this.name = spaceship.getName();
        this.description = spaceship.getDescription();
    }
    
}
