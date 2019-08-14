package com.jayway.robot.type;

/**
 * An enum containing Languages [Svenska, English]
 */
public enum LanguageType {
	SVENSKA("SVENSKA"), ENGLISH("ENGLISH");

	private String code;

	private LanguageType(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public static LanguageType getByCode(String code) {
		for (LanguageType languageType : LanguageType.values()) {
			if (languageType.code.equals(code)) {
				return languageType;
			}
		}

		return null;
	}
}
