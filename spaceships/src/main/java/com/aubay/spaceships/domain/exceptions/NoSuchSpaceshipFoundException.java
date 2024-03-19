package com.aubay.spaceships.domain.exceptions;

public class NoSuchSpaceshipFoundException extends RuntimeException {

	private static final long serialVersionUID = 6264297281831340341L;

	public NoSuchSpaceshipFoundException(String message) {
		super(message);
	}
}
