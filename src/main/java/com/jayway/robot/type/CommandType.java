package com.jayway.robot.type;

import java.util.ArrayList;
import java.util.List;

public enum CommandType {
	LEFT('L', 'V'), RIGHT('R', 'H'), FORWARD('F', 'G');

	private Character englishCode;
	private Character swedishCode;

	private CommandType(char englishCode, char swedishCode) {
		this.englishCode = englishCode;
		this.swedishCode = swedishCode;
	}

	public char getEnglishCode() {
		return englishCode;
	}

	public char getSwedishCode() {
		return swedishCode;
	}

	public static CommandType getByEnglishCode(char englishCode) {
		for (CommandType command : CommandType.values()) {
			if (command.getEnglishCode() == englishCode) {
				return command;
			}
		}

		return null;
	}

	public static CommandType getBySvenskaCode(char svenskaCode) {
		for (CommandType command : CommandType.values()) {
			if (command.getSwedishCode() == svenskaCode) {
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
}
