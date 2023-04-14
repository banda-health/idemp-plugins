package org.bandahealth.idempiere.base.utils;

public class NumberUtils {

	public static boolean isNumeric(String id) {
		return id != null && id.chars().allMatch(Character::isDigit);
	}
}
