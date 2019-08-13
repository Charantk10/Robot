package com.jayway.robot.exception;

public class NegativeMeasureException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public NegativeMeasureException() {
		super("Please select a positive integer value");
	}

	public NegativeMeasureException(Exception e) {
		super(e);
	}
}

