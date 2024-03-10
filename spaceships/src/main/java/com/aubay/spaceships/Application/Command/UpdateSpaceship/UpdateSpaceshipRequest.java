package com.aubay.spaceships.Application.Command.UpdateSpaceship;

public class UpdateSpaceshipRequest {

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

    public UpdateSpaceshipRequest(Long id, String name, String description) {
        this.id = id;
    	this.name = name;
        this.description = description;
    }
}