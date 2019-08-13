package com.jayway.robot.room;

import java.awt.Point;

import com.jayway.robot.exception.BusinessException;
import com.jayway.robot.type.CommandType;
import com.jayway.robot.type.DirectionType;

public abstract class AbstractRoom implements Room {
	protected Point currentPointPosition;
	protected Point startPointPosition;
	protected DirectionType currentDirection;
	protected Integer measure;

	public AbstractRoom(Point startPointPosition, Integer measure) {
		this.startPointPosition = startPointPosition;
		this.currentPointPosition = startPointPosition;
		this.measure = measure;
		this.currentDirection = DEFAULT_DIRECTION;
	}
	
	public Point getStartPosition() {
		return startPointPosition;
	}	

	public String getCurrentPositionWithDirection() {
		return currentPointPosition.x + " " + currentPointPosition.y + " " + currentDirection.getCode() ;
	}

	public Point getCurrentPosition() {
		return currentPointPosition;
	}
	
	@Override
	public boolean executeCommand(CommandType command) throws BusinessException {
		switch (command) {
		case RIGHT:
			currentDirection = DirectionType.getRightDirection(currentDirection);
			break;
		case LEFT:
			currentDirection = DirectionType.getLeftDirection(currentDirection);
			break;
		case FORWARD:
			moveForward();
			break;
		}
		
		return true;
	}	

}
