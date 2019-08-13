package com.jayway.robot.type;

public enum RoomType {
	CIRCULAR("circular"), SQUARE("square");
	
	private String description;
	
	private RoomType(String description) {
		this.description  = description;
	}
	
	

	public String getDescription() {
		return description;
	}		
}
