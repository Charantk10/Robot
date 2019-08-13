package com.jayway.robot;

import java.awt.Point;
import java.util.Scanner;

import com.jayway.robot.exception.BusinessException;
import com.jayway.robot.exception.StartingPositionOutOfRangeException;
import com.jayway.robot.room.Room;
import com.jayway.robot.room.RoomDataFactory;
import com.jayway.robot.type.CommandType;
import com.jayway.robot.type.LanguageType;
import com.jayway.robot.type.RoomType;
import com.jayway.robot.util.CommandLineUtil;
import com.jayway.robot.util.RoomUtil;

/**
 * The Command Line Interface for the 2 Dimensional Robot Application
 */
public class RobotCommandInterface {

	 /**
     * Handling the Commands from the User through the Command Line Interface and acts as the entry point for the Program    
     * @param String[] args classic main method
     * 
     */
	public static void main(String[] args) {				
		try (Scanner sn = new Scanner(System.in)) {
			LanguageType language = CommandLineUtil.selectLanguage(sn);			
			RoomType room = CommandLineUtil.selectRoomType(sn);		
			Integer measure = CommandLineUtil.selectMeasureByRoomType(sn, room);			
			Integer startXCoordinate = CommandLineUtil.selectXCoordinate(sn);			
			Integer startYCoordinate = CommandLineUtil.selectYCoordinate(sn);			
			String commandSequence = CommandLineUtil.selectCommandsSequence(sn);
			CommandRequest request = new CommandRequestBuilder().withLanguage(language).withRoomType(room)
					.withRoomMeasure(measure).withCoordinates(startXCoordinate, startYCoordinate)
					.withCommandSequence(commandSequence).createCommandRequest();
			executeCommand(request);
			
		} catch (BusinessException e) {
			System.out.println("Process terminated with the Error :"+ e.getMessage());
			System.exit(0);
		}
	}

	 /**
     * Handles the command sequence provided by the user by delegating to the corresponding classes      
     * @param com.jayway.robot.CommandRequest request     * 
     */
	private static void executeCommand(CommandRequest request) throws BusinessException {
		Point startingPoint = request.getStartingPoint();
		Integer measure = request.getRoomMeasure();
		RoomType roomType = request.getRoomType();
		validateStartingPointOfRoom(roomType, startingPoint, measure);
		Room type = RoomDataFactory.getRoomByType(request.getRoomType(), startingPoint, measure);
		if (type == null) {
			throw new BusinessException("The System does not support the RoomType");
		}
		String command = request.getCommand();
		for (int i = 0; i < command.length(); i++) {
			type.executeCommand(CommandType.validateAndGetCommand(command.charAt(i), request.getLanguage()));
		}

		System.out.println("Commands Successfully Executed");
		System.out.println(
				"The current position and direction of the Robot is : " + type.getCurrentPositionWithDirection());

	}
	
	 /**
     * Validating the Starting Point based on the x,y coordinates and the room type and measure provided through command interface     
     * @param com.jayway.robot.type.RoomType roomType
     * @param java.awt.Point point
     * @param Integer measure
     */
	private static boolean validateStartingPointOfRoom(RoomType roomType, Point point, Integer measure) throws BusinessException {
			if ( ! RoomUtil.validatePointInRoom(roomType, point, measure) ) {
				throw new StartingPositionOutOfRangeException();
			}			
		return true;
	}

}
