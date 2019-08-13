package com.jayway.robot.room;

import java.awt.Point;

import com.jayway.robot.exception.BusinessException;
import com.jayway.robot.type.RoomType;
import com.jayway.robot.util.RoomUtil;

/**
 * Circular Implementation of the Room
 */
public class CircularRoom extends AbstractRoom {

	public CircularRoom(Point startPointPosition, Integer radius) {
		super(startPointPosition, radius);
	}

	public boolean contains(Point position) {
		return RoomUtil.validatePointInRoom(RoomType.CIRCULAR, position, measure);
	}

	public void moveForward() throws BusinessException {
		switch (currentDirection) {
		case EAST:
			++currentPointPosition.x;
			break;
		case WEST:
			--currentPointPosition.x;
			break;
		case SOUTH:
			--currentPointPosition.y;
			break;
		case NORTH:
			++currentPointPosition.y;
			break;
		}

		if (!contains(currentPointPosition)) {
			throw new BusinessException("The Command provided are moving out of the room");
		}
	}

}
