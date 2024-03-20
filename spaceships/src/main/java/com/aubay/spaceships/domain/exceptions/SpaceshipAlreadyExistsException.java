package com.aubay.spaceships.domain.exceptions;

public class SpaceshipAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 409319034481812402L;

	public SpaceshipAlreadyExistsException(String message) {
		super(message);
	}
}
