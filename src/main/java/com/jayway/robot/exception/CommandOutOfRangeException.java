package com.jayway.robot.exception;

public class CommandOutOfRangeException extends BusinessException {

	private static final long serialVersionUID = 1L;
	
	public CommandOutOfRangeException() {
		super("The Command provided are moving out of the room");
	}

	public CommandOutOfRangeException(Exception e) {
		super(e);
	}

}
