package com.jayway.robot.exception;

import java.util.List;

/**
 * An Exception class for handling the Invalid Command Characters based on the
 * language
 */
public class InValidCommandCharactersException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public InValidCommandCharactersException(List<Character> list) {
		super("Invalid Command! Please make sure the command entered is inline with the selected language using any of these "
				+ list);
	}

	public InValidCommandCharactersException(Exception e) {
		super(e);
	}
}
