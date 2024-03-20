package com.aubay.spaceships.application.command.getspaceship;

import java.util.List;

import com.aubay.spaceships.domain.Spaceship;

public class GetSpaceshipsResponse {
	List<Spaceship> spaceshipList;

	public List<Spaceship> getSpaceshipList() {
		return spaceshipList;
	}

	public GetSpaceshipsResponse(List<Spaceship> spaceshipList) {
		this.spaceshipList = spaceshipList;
	}
	
	
}
