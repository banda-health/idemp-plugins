package org.bandahealth.idempiere.graphql.utils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;

public class DateUtil {
	public final static String DATE_FORMAT = "yyyy-MM-dd";

	public static String parseDateOnly(Timestamp timestamp, String dateFormat) {
		if (timestamp != null) {
			return new SimpleDateFormat(dateFormat).format(timestamp);
		}

		return null;
	}

	public static Timestamp getAPITimestamp(Object date, boolean shouldParseDateOnly) {
		if (date instanceof Integer || date instanceof Long || date instanceof Double || date instanceof BigDecimal) {
			long dateLong = date instanceof Integer ? Long.parseLong(date.toString()) : date instanceof Long ? (Long) date :
					date instanceof Double ? ((Double) date).longValue() : ((BigDecimal) date).longValue();
			if (shouldParseDateOnly) {
				// The DB is going to truncate the time AND auto-adjust it to it's time zone
				// So, subtract the offset so that the date is correct when the DB re-adds the time zone
				// ! NB: if the DB is on a different time zone than this server, there will be issues
				Instant instant = Instant.ofEpochMilli(dateLong);
				ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
//				return new Timestamp(dateLong - zonedDateTime.getOffset().getTotalSeconds() * 1000L);
			}
			return new Timestamp(dateLong);
		} else if (date instanceof String) {
			if (!shouldParseDateOnly) {
				try {
					return new Timestamp(new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSSX").parse((String) date).getTime());
				} catch (Exception ignored) {
				}
				try {
					return new Timestamp(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse((String) date).getTime());
				} catch (Exception ignored) {
				}
				try {
					return new Timestamp(new SimpleDateFormat("yyyy-MM-dd hh:mm").parse((String) date).getTime());
				} catch (Exception ignored) {
				}
			}
			try {
				return new Timestamp(new SimpleDateFormat("yyyy-MM-dd").parse((String) date).getTime());
			} catch (Exception ignored) {
			}
			try {
				return new Timestamp(new SimpleDateFormat("yyyy/MM/dd").parse((String) date).getTime());
			} catch (Exception ignored) {
			}
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
