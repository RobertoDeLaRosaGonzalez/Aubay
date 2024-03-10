package com.aubay.spaceships.Domain.Exceptions;

public class NoSuchSpaceshipFoundException extends RuntimeException {

	public NoSuchSpaceshipFoundException(String message) {
		super(message);
	}
}
