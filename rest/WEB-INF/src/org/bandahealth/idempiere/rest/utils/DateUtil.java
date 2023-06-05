package org.bandahealth.idempiere.rest.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import org.compiere.util.CLogger;

public class DateUtil {

	private final static String DEFAULT_FORMAT = "yyyy-MM-dd hh:mm:ss";
	private final static String REPORT_FORMAT = "yyyy-MM-dd hh:mm a";
	private final static String REPORT_FORMAT_2 = "yyyy-MM-dd'T'hh:mm:ss.SSSX";
	private final static String DATE_FORMAT = "yyyy-MM-dd";
	private final static String QUEUE_DATE_FORMAT = "E, dd MMMM - HH:mm";

	private static SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_FORMAT);
	private static CLogger log = CLogger.getCLogger(DateUtil.class);

	public static String parse(Timestamp timestamp) {
		if (timestamp != null) {
			return sdf.format(timestamp);
		}

		return null;
	}

	public static String parseDateOnly(Timestamp timestamp) {
		if (timestamp != null) {
			return new SimpleDateFormat(DATE_FORMAT).format(timestamp);
		}

		return null;

	}

	/**
	 * Parse Visit Queue Date
	 *
	 * @param timestamp
	 * @return
	 */
	public static String parseQueueTime(Timestamp timestamp) {
		if (timestamp != null) {
			return new SimpleDateFormat(QUEUE_DATE_FORMAT).format(timestamp);
		}

		return null;

	}

	/**
	 * Parse a YYYY-MM-DD (with or without the timestamp) to a Timestamp
	 *
	 * @param date
	 * @return
	 */
	public static Timestamp getTimestamp(String date) {
		return getTimestamp(date, DATE_FORMAT);
	}

	public static Timestamp getTimestampReportParameter(String date) {
		Timestamp parsedDate = getTimestamp(date, REPORT_FORMAT);
		if (parsedDate == null) {
			return getTimestamp(date, REPORT_FORMAT_2);
		}
		return parsedDate;
	}

	public static Timestamp getTimestamp(String date, String dateFormat) {
		if (date != null) {
			try {
				return new Timestamp(sdf.parse(date).getTime());
			} catch (ParseException e) {
				try {
					return new Timestamp(new SimpleDateFormat(dateFormat).parse(date).getTime());
				} catch (ParseException e1) {
					log.severe(e.getMessage());
				}
			}
		}

		return null;
	}

	public static Date parseDate(String date) {
		if (date != null) {
			try {
				return new SimpleDateFormat(DATE_FORMAT).parse(date);
			} catch (ParseException ex) {
				log.severe(ex.getMessage());
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

	/**
	 * Get a timestamp equal to the start of today (according to the system time)
	 *
	 * @return A timestamp for the start of today
	 */
	public static Timestamp startOfToday() {
		return atStartOfDay(new Timestamp(System.currentTimeMillis()));
	}

	/**
	 * Get a timestamp at the start of a given day (assuming the day is in the system's time zone)
	 *
	 * @param date The date to get the start of
	 * @return A timestamp for the start of that day
	 */
	public static Timestamp atStartOfDay(Timestamp date) {
		LocalDateTime localDateTime = dateToLocalDateTime(date);
		LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
		return localDateTimeToDate(startOfDay);
	}

	/**
	 * Get a timestamp at the end of a given day (assuming the day is in the system's time zone)
	 *
	 * @param date The date to get the end of
	 * @return A timestamp for the end of that day
	 */
	public static Timestamp atEndOfDay(Timestamp date) {
		LocalDateTime localDateTime = dateToLocalDateTime(date);
		LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
		return localDateTimeToDate(endOfDay);
	}

	private static LocalDateTime dateToLocalDateTime(Timestamp date) {
		return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
	}

	private static Timestamp localDateTimeToDate(LocalDateTime localDateTime) {
		return Timestamp.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}

	/**
	 * Check whether a guarantee date from an ASI is expired or not
	 *
	 * @param guaranteeDate The guarantee date to check
	 * @return Whether the date is expired
	 */
	public static boolean isGuaranteeDateExpired(Timestamp guaranteeDate) {
		Timestamp startOfToday = startOfToday();
		return guaranteeDate.getTime() >= startOfToday.getTime();
	}
}
