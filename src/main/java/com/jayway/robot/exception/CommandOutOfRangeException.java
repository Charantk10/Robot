package com.jayway.robot.exception;

/**
 * An Exception class to handle the Point Out of the room based on the provided commands
 */
public class CommandOutOfRangeException extends BusinessException {

	private static final long serialVersionUID = 1L;
	
	public CommandOutOfRangeException() {
		super("The Command provided are moving out of the room");
	}

	public CommandOutOfRangeException(Exception e) {
		super(e);
	}

}
