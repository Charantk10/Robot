package com.jayway.robot.room;

import java.awt.Point;

import com.jayway.robot.exception.BusinessException;
import com.jayway.robot.type.CommandType;
import com.jayway.robot.type.DirectionType;
import com.jayway.robot.type.RoomType;

public class SquareRoom implements Room {
	private Point currentPointPosition;
	private Point startPointPosition;
	private DirectionType currentDirection;
	private Integer side;
	
	public SquareRoom (Point startPointPosition, Integer side) {
		this.startPointPosition = startPointPosition;
		this.currentPointPosition = startPointPosition;		
		this.side = side;
		this.currentDirection = DEFAULT_DIRECTION;
	}
	
	@Override
	public Point getStartPosition() {		
		return startPointPosition;
	}

	@Override
	public boolean contains(Point position) {
		return RoomUtil.validatePointInRoom(RoomType.SQUARE, position, side);
	}

	@Override
	public boolean executeCommand(CommandType command) throws BusinessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getCurrentPositionWithDirection() {
		return currentPointPosition.x + " " + currentPointPosition.y + " " + currentDirection.getCode() ;
	}

}
