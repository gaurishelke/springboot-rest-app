package com.oracle.exceptions;

public class UniqueIdException extends RuntimeException{

	public UniqueIdException(String message) {
		super(message);
	}
	
	public UniqueIdException(String message, Throwable cause) {
		super(message, cause);
	}

	public UniqueIdException(Throwable cause) {
		super(cause);
	}
}
