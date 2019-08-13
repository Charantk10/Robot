package com.jayway.robot.room;

import java.awt.Point;

import com.jayway.robot.exception.BusinessException;
import com.jayway.robot.type.CommandType;
import com.jayway.robot.type.DirectionType;
import com.jayway.robot.type.RoomType;
import com.jayway.robot.util.RoomUtil;

public class CircularRoom implements Room {
	private Point currentPointPosition;
	private Point startPointPosition;
	private DirectionType currentDirection;
	private Integer radius;
	
	public CircularRoom (Point startPointPosition, Integer radius) {
		this.startPointPosition = startPointPosition;
		this.currentPointPosition = startPointPosition;		
		this.radius = radius;
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

	public boolean contains(Point position) {
		return RoomUtil.validatePointInRoom(RoomType.CIRCULAR, position, radius);
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
	
	private void moveForward() throws BusinessException {
		switch (currentDirection) {
		case EAST:
			++ currentPointPosition.x;
			break;
		case WEST:
			-- currentPointPosition.x;
			break;
		case SOUTH:
			-- currentPointPosition.y;
			break;
		case NORTH:
			++ currentPointPosition.y;	
			break;
		}
		
		if (!contains(currentPointPosition)) {
			throw new BusinessException("The Command provided are moving out of the room");
		}
	}	

}
