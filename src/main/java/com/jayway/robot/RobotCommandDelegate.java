package com.jayway.robot;

import static com.jayway.robot.room.RoomDataFactory.getRoomByType;
import static com.jayway.robot.type.CommandType.validateAndGetCommand;
import static com.jayway.robot.util.RoomUtil.validatePointInRoom;

import java.awt.Point;

import com.jayway.robot.exception.BusinessException;
import com.jayway.robot.exception.StartingPositionOutOfRangeException;
import com.jayway.robot.room.Room;
import com.jayway.robot.type.RoomType;

/**
 * Delegates the Commands and Validations to CommandUtil and RoomUtil      
 * 
 */
public class RobotCommandDelegate {

	 /**
     * Handles the command sequence provided by the user by delegating to the corresponding classes      
     * @param com.jayway.robot.CommandRequest request
     */
	public static String executeCommand(CommandRequest request) throws BusinessException {
		Point startingPoint = request.getStartingPoint();
		Integer measure = request.getRoomMeasure();
		RoomType roomType = request.getRoomType();
		validateStartingPointOfRoom(roomType, startingPoint, measure);
		Room type = getRoomByType(request.getRoomType(), startingPoint, measure);	
		String command = request.getCommand();
		for (int i = 0; i < command.length(); i++) {
			type.executeCommand(validateAndGetCommand(command.charAt(i), request.getLanguage()));
		}

		System.out.println("Commands Successfully Executed");
		return type.getCurrentPositionWithDirection();

	}
	
	 /**
     * Validating the Starting Point based on the x,y coordinates and the room type and measure provided through command interface     
     * @param com.jayway.robot.type.RoomType roomType
     * @param java.awt.Point point
     * @param Integer measure
     */
	private static boolean validateStartingPointOfRoom(RoomType roomType, Point point, Integer measure) throws BusinessException {
			if ( !validatePointInRoom(roomType, point, measure) ) {
				throw new StartingPositionOutOfRangeException();
			}			
		return true;
	}

}
