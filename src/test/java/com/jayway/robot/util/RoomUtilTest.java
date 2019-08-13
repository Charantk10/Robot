package com.jayway.robot.util;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import com.jayway.robot.type.RoomType;

public class RoomUtilTest {	
	public static final Integer SIDE_OF_SQUARE = 5;
	public static final Integer RADIUS_OF_CIRCLE = 11;

	@Test
	public void pointOnSquareWithinRoom() {	
		Point point = new Point();
		point.setLocation(1, 4);		
		Boolean result = RoomUtil.validatePointInRoom(RoomType.SQUARE, point, SIDE_OF_SQUARE);
		assertEquals(result, Boolean.TRUE);
	}
	
	@Test
	public void pointOnSquareOutOfTheRoom() {	
		Point point = new Point();
		point.setLocation(6, 4);
		Boolean result = RoomUtil.validatePointInRoom(RoomType.SQUARE, point, SIDE_OF_SQUARE);
		assertEquals(result, Boolean.FALSE);
	}
	
	@Test
	public void pointOnCircleWithinTheRoom() {	
		Point point = new Point();
		point.setLocation(6, 4);
		Boolean result = RoomUtil.validatePointInRoom(RoomType.CIRCULAR, point, RADIUS_OF_CIRCLE);
		assertEquals(result, Boolean.TRUE);
	}
	
	@Test
	public void pointOnCirecleOutOfTheRoom() {
		Point point = new Point();
		point.setLocation(10, 5);
		Boolean result = RoomUtil.validatePointInRoom(RoomType.CIRCULAR, point, RADIUS_OF_CIRCLE);
		assertEquals(result, Boolean.FALSE);
	}

}
