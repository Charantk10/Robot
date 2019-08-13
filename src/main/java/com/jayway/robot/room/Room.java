package com.jayway.robot.room;

import com.jayway.robot.exception.BusinessException;
import com.jayway.robot.type.CommandType;
import com.jayway.robot.type.DirectionType;

public interface Room {

	public static final DirectionType DEFAULT_DIRECTION = DirectionType.NORTH;

	java.awt.Point getStartPosition();

	boolean contains(java.awt.Point position);

	boolean executeCommand(CommandType command) throws BusinessException;

	public String getCurrentPositionWithDirection();
}
