package com.jayway.robot.util;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.jayway.robot.exception.InvalidInputIntException;
import com.jayway.robot.type.LanguageType;
import com.jayway.robot.type.RoomType;
/**
 * An Utility Class for handling the Command Line Inputs from the user
 */
public class CommandLineUtil {

	/**
	 * Prompts the user with the Languages returns the selected Language
	 * @param java.util.Scanner
	 * @return LanguageType
	 */
	public static LanguageType selectLanguage(Scanner sn) {
		// Print the options for the user to choose from
		LanguageType language = null;
		System.out.println("Please Select the Lanuage, In which you want to Provide Commands");
		System.out.println("1." + LanguageType.ENGLISH.getCode());
		System.out.println("2. " + LanguageType.SVENSKA.getCode());
		System.out.println("*. Press 3 to exit");
		// Prompt the use to make a choice
		System.out.println("Enter your choice:");

		Boolean inValidInput = Boolean.TRUE;
		while (inValidInput) {
			Integer userInput = sn.nextInt();
			switch (userInput) {
			case 1:
				language = LanguageType.ENGLISH;
				inValidInput = Boolean.FALSE;
				break;
			case 2:
				language = LanguageType.SVENSKA;
				inValidInput = Boolean.FALSE;
				break;
			case 3:
				// exit from the program
				System.out.println("Exiting...");
				System.exit(0);
			default:
				System.out.println("Invalid choice. Read the options carefully and Enter again");
			}
		}

		return language;
	}

	/**
	 * Prompts the user with the Room Types returns the selected RoomType
	 * @param java.util.Scanner
	 * @return RoomType
	 */
	public static RoomType selectRoomType(Scanner sn) {
		// Print the options for the user to choose from
		RoomType roomType = null;
		System.out.println("Please Select the Type of the room");
		System.out.println("1." + RoomType.CIRCULAR);
		System.out.println("2. " + RoomType.SQUARE);
		System.out.println("*. Press 3 to exit");
		// Prompt the use to make a choice
		System.out.println("Enter your choice:");

		Boolean inValidInput = Boolean.TRUE;
		while (inValidInput) {
			Integer userInput = sn.nextInt();
			switch (userInput) {
			case 1:
				roomType = RoomType.CIRCULAR;
				inValidInput = Boolean.FALSE;
				break;
			case 2:
				roomType = RoomType.SQUARE;
				inValidInput = Boolean.FALSE;
				break;
			case 3:
				// exit from the program
				System.out.println("Exiting...");
				System.exit(0);
			default:
				System.out.println("Invalid choice. Read the options carefully and Enter again");
			}
		}

		return roomType;
	}

	/**
	 * Prompts the user with an option to enter the measure(side or radius) depending upon the RoomType
	 * @param java.util.Scanner
	 * @param RoomType
	 * @return Integer
	 */
	public static Integer selectMeasureByRoomType(Scanner sn, RoomType roomType) throws InvalidInputIntException {
		if (roomType == RoomType.CIRCULAR) {
			System.out.println("Please Enter the radius of the room");
		} else {
			System.out.println("Please Enter the side of the square");
		}
		return acceptIntInput(sn);
	}

	/**
	 * Prompts the user with an option to enter the starting point xcoordinate of the room 
	 * @param java.util.Scanner
	 * @return Integer
	 */
	public static Integer selectXCoordinate(Scanner sn) throws InvalidInputIntException {
		System.out.println("Please Enter a starting x coordinate");
		return acceptIntInput(sn);
	}

	/**
	 * Prompts the user with an option to enter the starting point ycoordinate of the room 
	 * @param java.util.Scanner
	 * @return Integer
	 */
	public static Integer selectYCoordinate(Scanner sn) throws InvalidInputIntException {
		System.out.println("Please Enter a starting y coordinate");
		return acceptIntInput(sn);
	}

	/**
	 * Prompts the user to enter input as an Integer 
	 * @param java.util.Scanner
	 * @return Integer
	 */
	private static Integer acceptIntInput(Scanner sn) throws InvalidInputIntException {
		try {
			return sn.nextInt();
		} catch (InputMismatchException e) {
			throw new InvalidInputIntException();
		}
	}

	/**
	 * Prompts the user to enter Commands as a sequence of characters 
	 * @param java.util.Scanner
	 * @return String
	 */
	public static String selectCommandsSequence(Scanner sn) {
		System.out.println("Please Enter a command sequence");
		return sn.next();
	}	
}
