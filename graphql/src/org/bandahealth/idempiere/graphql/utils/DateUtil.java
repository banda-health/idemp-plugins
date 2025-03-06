package org.bandahealth.idempiere.graphql.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {
	public final static String DATE_FORMAT = "yyyy-MM-dd";

	public static String parseDateOnly(Timestamp timestamp, String dateFormat) {
		if (timestamp != null) {
			return new SimpleDateFormat(dateFormat).format(timestamp);
		}

		return null;
	}

	public static Timestamp getAPITimestamp(String date) {
		try {
			return new Timestamp(new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSSX").parse(date).getTime());
		} catch (Exception ignored) {
		}
		try {
			return new Timestamp(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(date).getTime());
		} catch (Exception ignored) {
		}
		try {
			return new Timestamp(new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(date).getTime());
		} catch (Exception ignored) {
		}
		try {
			return new Timestamp(new SimpleDateFormat("yyyy-MM-dd").parse(date).getTime());
		} catch (Exception ignored) {
		}
		try {
			return new Timestamp(new SimpleDateFormat("yyyy/MM/dd").parse(date).getTime());
		} catch (Exception ignored) {
		}

		return null;
	}

	/**
	 * Adds a day to the passed-in timestamp
	 *
	 * @param currentDay The timestamp to get a day from
	 * @return A timestamp exactly 1 day ahead
	 */
	public static Timestamp getTheNextDay(Timestamp currentDay) {
		Calendar endDateCalendar = Calendar.getInstance();
		endDateCalendar.setTime(currentDay);
		endDateCalendar.add(Calendar.DATE, 1);
		return new Timestamp(endDateCalendar.getTimeInMillis());
	}
}
