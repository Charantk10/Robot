package com.jayway.robot.util;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.jayway.robot.exception.BusinessException;
import com.jayway.robot.exception.InvalidInputIntException;
import com.jayway.robot.exception.NegativeMeasureException;
import com.jayway.robot.type.LanguageType;
import com.jayway.robot.type.RoomType;

/**
 * An Utility Class for handling the Command Line Inputs from the user
 */
public class CommandLineUtil {

	/**
	 * Prompts the user with the Languages returns the selected Language
	 * 
	 * @param java.util.Scanner
	 * @return LanguageType
	 */
	public static LanguageType selectLanguage(Scanner sn) {
		// Print the options for the user to choose from
		LanguageType language = null;
		System.out.println("Welcome to Robot Programming!");
		System.out.println("Please select the language to provide your Commands");
		System.out.println("1." + LanguageType.ENGLISH.getCode());
		System.out.println("2." + LanguageType.SVENSKA.getCode());
		System.out.println("3.Exit");
		// Prompt the user to make a choice
		System.out.println("Enter your choice:");

		Boolean inValidInput = Boolean.TRUE;
		while (inValidInput) {
			String userInput = sn.next();
			userInput = userInput.trim();
			switch (userInput) {
			case "1":
				language = LanguageType.ENGLISH;
				inValidInput = Boolean.FALSE;
				break;
			case "2":
				language = LanguageType.SVENSKA;
				inValidInput = Boolean.FALSE;
				break;
			case "3":
				// exit from the program
				System.out.println("Exiting...");
				System.exit(0);
			default:
				System.out.println("Invalid choice. Please read the options carefully and enter again");
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
		System.out.println("Please select the type of the Room");
		System.out.println("1." + RoomType.CIRCULAR);
		System.out.println("2." + RoomType.SQUARE);
		System.out.println("3.Exit");
		// Prompt the user to make a choice
		System.out.println("Enter your choice:");

		Boolean inValidInput = Boolean.TRUE;
		while (inValidInput) {
			String userInput = sn.next();
			userInput = userInput.trim();
			switch (userInput) {
			case "1":
				roomType = RoomType.CIRCULAR;
				inValidInput = Boolean.FALSE;
				break;
			case "2":
				roomType = RoomType.SQUARE;
				inValidInput = Boolean.FALSE;
				break;
			case "3":
				// exit from the program
				System.out.println("Exiting...");
				System.exit(0);
			default:
				System.out.println("Invalid choice. Please read the options carefully and enter again");
			}
		}

		return roomType;
	}

	/**
	 * Prompts the user with an option to enter the measure(side or radius)
	 * depending upon the RoomType
	 *  
	 * @param java.util.Scanner
	 * @param RoomType
	 * @return Integer
	 */
	public static Integer selectMeasureByRoomType(Scanner sn, RoomType roomType) throws BusinessException {
		if (roomType == RoomType.CIRCULAR) {
			System.out.println("Please enter the Radius of the room (Eg:10)");
		} else {
			System.out.println("Please enter the side of the square (Eg:5)");
		}

		Integer measure = acceptIntInput(sn);
		if (measure < 0) {
			throw new NegativeMeasureException();
		}

		return measure;
	}

	/**
	 * Prompts the user with an option to enter the starting point xcoordinate of
	 * the room
	 * 
	 * @param java.util.Scanner
	 * @return Integer
	 */
	public static Integer selectXCoordinate(Scanner sn) throws InvalidInputIntException {
		System.out.println("Please enter a starting x coordinate (Eg: If coordinates are (1,2) x coordinate is 1)");
		return acceptIntInput(sn);
	}

	/**
	 * Prompts the user with an option to enter the starting point y coordinate of
	 * the room
	 * 
	 * @param java.util.Scanner
	 * @return Integer
	 */
	public static Integer selectYCoordinate(Scanner sn) throws InvalidInputIntException {
		System.out.println("Please enter a starting y coordinate (Eg: If coordinates are (1,2) y coordinate is 2)");
		return acceptIntInput(sn);
	}

	/**
	 * Prompts the user to enter input as an Integer
	 * 
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
	 * 
	 * @param java.util.Scanner
	 * @return String
	 */
	public static String selectCommandsSequence(Scanner sn) {
		System.out.println("Please enter the relevant Command Sequence (Eg: FRFFL/GHGGV as relevant to your language");
		return sn.next();
	}
}
