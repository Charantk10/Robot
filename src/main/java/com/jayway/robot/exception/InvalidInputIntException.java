package com.jayway.robot.exception;

/**
 * An Exception class for handling the invalid Integer value
 */
public class InvalidInputIntException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public InvalidInputIntException() {
		super("Invalid entry for an Integer Input");
	}

	public InvalidInputIntException(Exception e) {
		super(e);
	}
}
