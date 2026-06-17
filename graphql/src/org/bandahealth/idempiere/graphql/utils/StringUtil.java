package org.bandahealth.idempiere.graphql.utils;

import java.util.List;

/**
 * A class containing string utility functions
 */
public class StringUtil {
	private static final List<String> SENSITIVE_JSON_FIELD_NAMES = List.of("Password", "NewPassword", "Answer");
	/**
	 * Check if string is null or empty
	 *
	 * @param s The string to check
	 * @return Whether the string is null or empty
	 */
	public static boolean isNullOrEmpty(String s) {
		return s == null || s.isEmpty();
	}

	/**
	 * Remove newlines from a string
	 *
	 * @param s The string to fix
	 * @return A string without newlines
	 */
	public static String stripNewLines(String s) {
		return s == null ? null : s.replace("\r", "").replace("\n", "");
	}

	/**
	 * Mask sensitive values in a JSON string before logging (e.g. passwords and security answers).
	 *
	 * @param jsonString The JSON string to mask
	 * @return A JSON string with sensitive field values replaced by "***"
	 */
	public static String maskSensitiveJsonStringValues(String jsonString) {
		if (jsonString == null) {
			return null;
		}
		String maskedJsonString = jsonString;
		for (String fieldName : SENSITIVE_JSON_FIELD_NAMES) {
			maskedJsonString = maskedJsonString.replaceAll(
					"(\"" + fieldName + "\"\\s*:\\s*\")((?:[^\"\\\\]|\\\\.)*)(\")",
					"$1***$3"
			);
		}
		return maskedJsonString;
	}
}
