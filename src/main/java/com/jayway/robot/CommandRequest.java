package com.jayway.robot;

import java.awt.Point;

import com.jayway.robot.type.LanguageType;
import com.jayway.robot.type.RoomType;

public class CommandRequest {
	private String command;
	private LanguageType language;
	private RoomType roomType;
	private Point startingPoint;
	private Integer roomMeasure;

	public CommandRequest(String command, LanguageType language, RoomType roomType,Point startingPoint, Integer roomMeasure) {
		super();
		this.command = command;
		this.language = language;
		this.roomType = roomType;
		this.startingPoint = startingPoint;
		this.roomMeasure = roomMeasure;
	}

	public String getCommand() {
		return command;
	}

	public Point getStartingPoint() {
		return startingPoint;
	}	

	public Integer getRoomMeasure() {
		return roomMeasure;
	}
	
	public LanguageType getLanguage() {
		return language;
	}

	public RoomType getRoomType() {
		return roomType;
	}
	
}
