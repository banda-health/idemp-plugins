package org.bandahealth.idempiere.rest.utils;

public class StringUtil {

	/**
	 * Check if string is not null and empty
	 * @param name
	 * @return
	 */
	public static boolean isNotNullAndEmpty(String name) {
		return name != null && !name.isEmpty();
	}
}
