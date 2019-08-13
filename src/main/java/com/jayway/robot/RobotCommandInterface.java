package com.jayway.robot;

import java.awt.Point;
import java.util.Scanner;

import com.jayway.robot.exception.BusinessException;
import com.jayway.robot.exception.StartingPositionOutOfRangeException;
import com.jayway.robot.room.Room;
import com.jayway.robot.room.RoomDataFactory;
import com.jayway.robot.util.RoomUtil;
import com.jayway.robot.util.CommandLineUtil;
import com.jayway.robot.type.LanguageType;
import com.jayway.robot.type.RoomType;

/**
 * Hello world!
 *
 */
public class RobotCommandInterface {

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
			System.out.println("Prrocess Terminated with the Error :"+ e.getMessage());
			System.exit(0);
		}
	}

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
			type.executeCommand(CommandLineUtil.validateAndGetCommand(command.charAt(i), request.getLanguage()));
		}

		System.out.println("Commands Successfully Executed");
		System.out.println(
				"The current position and direction of the Robot is : " + type.getCurrentPositionWithDirection());

	}
	
	
	private static boolean validateStartingPointOfRoom(RoomType roomType, Point point, Integer measure) throws BusinessException {
		if (roomType == RoomType.CIRCULAR) {
			if ( ! RoomUtil.validatePointInRoom(roomType, point, measure) ) {
				throw new StartingPositionOutOfRangeException();
			}
		}		
		return true;
	}

}
