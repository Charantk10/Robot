package com.jayway.robot;

import java.awt.Point;

import com.jayway.robot.type.LanguageType;
import com.jayway.robot.type.RoomType;

/**
 * A class representing the Request for the CommandInterface
 */
public class CommandRequest {
	/**
	 * Sequence of Commands
	 */
	private String command;
	
	/**
	 * Language opted
	 */
	private LanguageType language;
	/**
	 * Type of Room 
	 */
	private RoomType roomType;
	/**
	 * Starting Point with x and y coordinates
	 */
	private Point startingPoint;
	/**
	 * measure of the room 
	 * contains side for square 
	 * contains radius for circle
	 */
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
