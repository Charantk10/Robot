package com.jayway.robot.exception;

/**
 * An Exception class to handle the Point Out of the room based on the provided commands
 */
public class CommandOutOfRangeException extends BusinessException {

	private static final long serialVersionUID = 1L;
	
	public CommandOutOfRangeException() {
		super("The provided command moves the Robot out of the room. Please execute the program again with a valid command");
	}

	public CommandOutOfRangeException(Exception e) {
		super(e);
	}

}
