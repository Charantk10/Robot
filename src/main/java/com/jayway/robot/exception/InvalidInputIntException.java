package com.jayway.robot.exception;

public class InvalidInputIntException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public InvalidInputIntException() {
		super("Invalid Entry for an Integer Input");
	}

	public InvalidInputIntException(Exception e) {
		super(e);
	}
}
