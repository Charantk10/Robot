package com.jayway.robot.exception;

public class StartingPositionOutOfRangeException extends BusinessException{

	private static final long serialVersionUID = 1L;
	
	public StartingPositionOutOfRangeException() {
		super("The provided starting point is out of range for the provided Radius");
	}

	public StartingPositionOutOfRangeException(Exception e) {
		super(e);
	}

}
