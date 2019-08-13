package com.jayway.robot.type;

import java.util.ArrayList;
import java.util.List;

import com.jayway.robot.exception.BusinessException;
import com.jayway.robot.exception.InValidCommandCharactersException;

/**
 * An enum for containing the Commands in svenska and english languages
 */
public enum CommandType {
	LEFT('L', 'V'), RIGHT('R', 'H'), FORWARD('F', 'G');

	private Character englishCode;
	private Character swedishCode;

	private CommandType(char englishCode, char swedishCode) {
		this.englishCode = englishCode;
		this.swedishCode = swedishCode;
	}

	public Character getEnglishCode() {
		return englishCode;
	}

	public Character getSwedishCode() {
		return swedishCode;
	}

	public static CommandType getByEnglishCode(Character englishCode) {
		for (CommandType command : CommandType.values()) {
			if (command.getEnglishCode().toString().equalsIgnoreCase(englishCode.toString())) {
				return command;
			}
		}

		return null;
	}

	public static CommandType getBySvenskaCode(Character svenskaCode) {
		for (CommandType command : CommandType.values()) {
			if (command.getSwedishCode().toString().equalsIgnoreCase(svenskaCode.toString())) {
				return command;
			}
		}

		return null;
	}

	public static List<Character> getCommandCodesByLanguage(LanguageType languageType) {
		List<Character> commandCodes = new ArrayList<>();

		for (CommandType command : CommandType.values()) {
			commandCodes.add(languageType == LanguageType.ENGLISH ? command.englishCode : command.swedishCode);
		}

		return commandCodes;

	}

	public static List<Character> getSvenskaCodesCodes() {
		List<Character> englishCodes = new ArrayList<>();

		for (CommandType command : CommandType.values()) {
			englishCodes.add(command.englishCode);
		}
		return englishCodes;
	}

	public static CommandType validateAndGetCommand(char command, LanguageType languageType) throws BusinessException {
		CommandType commandType;
		if (languageType == LanguageType.ENGLISH) {
			commandType = CommandType.getByEnglishCode(command);
		} else {
			commandType = CommandType.getBySvenskaCode(command);
		}

		if (commandType == null) {
			throw new InValidCommandCharactersException(CommandType.getCommandCodesByLanguage(languageType));
		}

		return commandType;
	}
}
