package com.jayway.robot.util;

import java.awt.Point;

import com.jayway.robot.type.RoomType;

public class RoomUtil {

	public static boolean validatePointInRoom(RoomType roomType, Point position, Integer measure) {
		if (roomType == RoomType.CIRCULAR) {
			return validateCircularRoomPoint(position, measure);
		} else {
			return validateSquareRoomPoint(position, measure);
		}
	}
	
	
	private static boolean validateCircularRoomPoint(Point position, Integer radius) {
		int xCordinate = position.x;
		int yCordinate = position.y;
		
		int distanceFromTheOrigin =  xCordinate * xCordinate + yCordinate * yCordinate;
		int maxDistanceToBeIntheRoom = radius * radius;
		
		if (distanceFromTheOrigin > maxDistanceToBeIntheRoom) {
			return false;
		}
		 return true;
	}
	
	private static boolean validateSquareRoomPoint(Point position, Integer side) {
		Integer xCoordinate = position.x;
		Integer yCoordinate = position.y;
		
		if ((xCoordinate > side || xCoordinate < 0 ) && (yCoordinate > side || yCoordinate < 0)) {
			return false;
		}
		
		return true;	
	}
}
