package com.jayway.robot;

import static com.jayway.robot.RobotCommandDelegate.executeCommand;
import java.util.Scanner;
import com.jayway.robot.exception.BusinessException;
import com.jayway.robot.type.LanguageType;
import com.jayway.robot.type.RoomType;
import com.jayway.robot.util.CommandLineUtil;;

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
			System.out.println(executeCommand(request));
			
		} catch (BusinessException e) {
			System.out.println("Process terminated with the Error :"+ e.getMessage());
			System.exit(0);
		}
	}	
}
