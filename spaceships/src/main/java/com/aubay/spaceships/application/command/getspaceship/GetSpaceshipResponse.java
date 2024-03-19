package com.aubay.spaceships.application.command.getspaceship;

import com.aubay.spaceships.domain.Spaceship;

public class GetSpaceshipResponse {
	
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

    public GetSpaceshipResponse(Spaceship spaceship) {
    	this.id = spaceship.getId();
        this.name = spaceship.getName();
        this.description = spaceship.getDescription();
    }
    
}
