package com.jayway.robot;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import static com.jayway.robot.RobotCommandDelegate.executeCommand;
import org.junit.Test;

import com.jayway.robot.exception.BusinessException;
import com.jayway.robot.exception.CommandOutOfRangeException;
import com.jayway.robot.exception.InValidCommandCharactersException;
import com.jayway.robot.exception.StartingPositionOutOfRangeException;
import com.jayway.robot.type.LanguageType;
import com.jayway.robot.type.RoomType;

public class RobotCommandDelegateTest {	
	public static final Integer SQUARE_SIDE = 5;
	public static final String COMMAND_SVENSKA = "HGHGVG";
	public static final Integer CIRCLE_RADIUS = 12;
	public static final String COMMAND_ENGLISH = "RFFLFRLRF";
	public static final String COMMAND_OUT_OF_RANGE_ENGLISH = "RFFFFFR";	

	CommandRequestBuilder commandRequestBuilder;
	@Before
	public void init() {
		commandRequestBuilder = new CommandRequestBuilder();
	}
	
	@Test(expected = StartingPositionOutOfRangeException.class)
	public void squareStartingPointOutOfRoom() throws BusinessException {
		CommandRequest request = commandRequestBuilder.withLanguage(LanguageType.ENGLISH).withRoomType(RoomType.SQUARE)
				.withRoomMeasure(SQUARE_SIDE).withCoordinates(1, 6).withCommandSequence(COMMAND_SVENSKA)
				.createCommandRequest();
		executeCommand(request);
	}
	
	@Test(expected = StartingPositionOutOfRangeException.class)
	public void circleStartingPointOutOfRoom() throws BusinessException {
		CommandRequest request = commandRequestBuilder.withLanguage(LanguageType.ENGLISH).withRoomType(RoomType.CIRCULAR)
				.withRoomMeasure(CIRCLE_RADIUS).withCoordinates(11, 9).withCommandSequence(COMMAND_SVENSKA)
				.createCommandRequest();
		executeCommand(request);
	}
	
	@Test(expected = InValidCommandCharactersException.class)
	public void invalidCommandsSequenceForSvenska() throws BusinessException {
		CommandRequest request = commandRequestBuilder.withLanguage(LanguageType.SVENSKA).withRoomType(RoomType.CIRCULAR)
				.withRoomMeasure(CIRCLE_RADIUS).withCoordinates(1, 8).withCommandSequence(COMMAND_ENGLISH)
				.createCommandRequest();
		executeCommand(request);
	}
	
	@Test(expected = InValidCommandCharactersException.class)
	public void invalidCommandsSequenceForEnglish() throws BusinessException {
		CommandRequest request = commandRequestBuilder.withLanguage(LanguageType.ENGLISH).withRoomType(RoomType.CIRCULAR)
				.withRoomMeasure(CIRCLE_RADIUS).withCoordinates(1, 8).withCommandSequence(COMMAND_SVENSKA)
				.createCommandRequest();
		executeCommand(request);
	}
	
	@Test(expected = CommandOutOfRangeException.class)
	public void commandDrivesOutOFTheSquareRoom() throws BusinessException {
		CommandRequest request = commandRequestBuilder.withLanguage(LanguageType.ENGLISH).withRoomType(RoomType.SQUARE)
				.withRoomMeasure(SQUARE_SIDE).withCoordinates(1, 1).withCommandSequence(COMMAND_OUT_OF_RANGE_ENGLISH)
				.createCommandRequest();
		executeCommand(request);
	}
	
	@Test(expected = CommandOutOfRangeException.class)
	public void commandDrivesOutOFTheCircularRoom() throws BusinessException {
		CommandRequest request = commandRequestBuilder.withLanguage(LanguageType.ENGLISH).withRoomType(RoomType.CIRCULAR)
				.withRoomMeasure(CIRCLE_RADIUS).withCoordinates(1, 11).withCommandSequence(COMMAND_OUT_OF_RANGE_ENGLISH)
				.createCommandRequest();
		executeCommand(request);
	}
	
	@Test
	public void validSvenskaCommandForCircle() throws BusinessException {
		CommandRequest request = commandRequestBuilder.withLanguage(LanguageType.SVENSKA).withRoomType(RoomType.CIRCULAR)
				.withRoomMeasure(CIRCLE_RADIUS).withCoordinates(1, 8).withCommandSequence(COMMAND_SVENSKA)
				.createCommandRequest();
		 assertEquals(executeCommand(request), "3 7 Ö");
	}
	
	@Test
	public void validEnglishCommandForSquare() throws BusinessException {
		CommandRequest request = commandRequestBuilder.withLanguage(LanguageType.ENGLISH).withRoomType(RoomType.CIRCULAR)
				.withRoomMeasure(CIRCLE_RADIUS).withCoordinates(1, 8).withCommandSequence(COMMAND_ENGLISH)
				.createCommandRequest();
		 assertEquals(executeCommand(request), "4 9 Ö");
	}
}
