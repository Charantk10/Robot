package com.jayway.robot.type;

/**
 * An enum containing Directions 
 */
public enum DirectionType {
	EAST ("Ö"), WEST ("W"), NORTH ("N"), SOUTH ("S");
	
	private DirectionType (String code) {
		this.code = code;
	}
	
	private String code;

	public String getCode() {
		return code;
	}
	
	public static DirectionType getLeftDirection(DirectionType direction) {
    	switch (direction) {
    	case EAST:
    		return NORTH;
    	case WEST:
    		return SOUTH;
    	case NORTH:
    		return WEST;
    	case SOUTH:
    		return EAST;
    	default:
    		return null;
    	}
    }
    
    public static DirectionType getRightDirection(DirectionType direction) {
    	switch (direction) {
    	case EAST:
    		return DirectionType.SOUTH;
    	case WEST:
    		return DirectionType.NORTH;
    	case NORTH:
    		return DirectionType.EAST;
    	case SOUTH:
    		return DirectionType.WEST;
    	default:
    		return null;
    	}
    }
	
}
