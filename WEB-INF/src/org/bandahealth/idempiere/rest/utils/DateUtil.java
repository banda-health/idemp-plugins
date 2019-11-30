package org.bandahealth.idempiere.rest.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DateUtil {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public static String parse(Timestamp timestamp) {
		if (timestamp != null) {
			return sdf.format(timestamp);
		}

		return null;
	}
}
