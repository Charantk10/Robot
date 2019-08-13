package com.jayway.robot.room;

import com.jayway.robot.exception.BusinessException;
import com.jayway.robot.type.CommandType;
import com.jayway.robot.type.DirectionType;

/**
 * An interface to handle the robot moment in the room
 */
public interface Room {
	public static final DirectionType DEFAULT_DIRECTION = DirectionType.NORTH;

	/**	 
	 * Gets the starting position i.e the Input provided by the user 
	 * @return java.awt.Point
	 */
	java.awt.Point getStartPosition();

	/**	 
	 * checks if a particular point exists in the room
	 * @param java.awt.Point
	 * @return boolean
	 */
	boolean contains(java.awt.Point position);

	/**	 
	 * executes one command
	 * @param com.jayway.robot.type.CommandType  
	 */
	void executeCommand(CommandType command) throws BusinessException;

	/**	 
	 * Gets the current point and direction of the robot in the room as String
	 * @return String 
	 */
	String getCurrentPositionWithDirection();

	/**	 
	 * Moves the robot 1 step forward in the current direction
	 * 
	 */
	void moveForward() throws BusinessException;
}
