package org.bandahealth.idempiere.rest.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DateUtil {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static String parse(Timestamp timestamp) {
		return sdf.format(timestamp);
	}
}
