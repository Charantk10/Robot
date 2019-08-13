package com.jayway.robot.room;

import java.awt.Point;

import com.jayway.robot.exception.BusinessException;
import com.jayway.robot.exception.CommandOutOfRangeException;
import com.jayway.robot.type.RoomType;
import com.jayway.robot.util.RoomUtil;

/**
 * Square Implementation of the Room
 */
public class SquareRoom extends AbstractRoom {

	public SquareRoom(Point startPointPosition, Integer side) {
		super(startPointPosition, side);
	}

	@Override
	public boolean contains(Point position) {
		return RoomUtil.validatePointInRoom(RoomType.SQUARE, position, measure);
	}

	@Override
	public void moveForward() throws BusinessException {
		switch (currentDirection) {
		case EAST:
			--currentPointPosition.x;
			break;
		case WEST:
			++currentPointPosition.x;
			break;
		case SOUTH:
			++currentPointPosition.y;
			break;
		case NORTH:
			--currentPointPosition.y;
			break;
		}

		if (!contains(currentPointPosition)) {
			throw new CommandOutOfRangeException();
		}
	}

}
