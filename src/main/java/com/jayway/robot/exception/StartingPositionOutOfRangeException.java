package com.jayway.robot.exception;

/**
 * An Exception class for handling out of range starting point in the room
 */
public class StartingPositionOutOfRangeException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public StartingPositionOutOfRangeException() {
		super("The provided starting point is out of range for your room");
	}

	public StartingPositionOutOfRangeException(Exception e) {
		super(e);
	}

}
