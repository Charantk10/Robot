package com.jayway.robot;

import java.awt.Point;

import com.jayway.robot.type.LanguageType;
import com.jayway.robot.type.RoomType;

public class CommandRequestBuilder {
	private String command;
	private LanguageType language;
	private RoomType roomType;
	private Point startingPoint;
	private Integer roomMeasure;
	
	public CommandRequestBuilder withLanguage(LanguageType languageType) {
		this.language = languageType;
		return this;
	}
	
	public CommandRequestBuilder withRoomType(RoomType room) {
		this.roomType = room;
		return this;
	}
	
	public CommandRequestBuilder withRoomMeasure(Integer measure) {
		this.roomMeasure = measure;
		return this;
	}
	
	public CommandRequestBuilder withCoordinates(Integer xCoordinate, Integer yCoordinate) {
		this.startingPoint = new Point(xCoordinate, yCoordinate);
		return this;
	}
	
	public CommandRequestBuilder withCommandSequence(String commands) {
		this.command = commands;
		return this;
	}
	
	public CommandRequest createCommandRequest() {
		return new CommandRequest(command, language, roomType, startingPoint, roomMeasure);
	}
}
