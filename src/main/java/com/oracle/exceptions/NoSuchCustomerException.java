package com.oracle.exceptions;

import ch.qos.logback.core.helpers.ThrowableToStringArray;

public class NoSuchCustomerException extends RuntimeException{

	public NoSuchCustomerException(String message) {
		super(message);
	}
	
	public NoSuchCustomerException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoSuchCustomerException(Throwable cause) {
		super(cause);
	}
}
