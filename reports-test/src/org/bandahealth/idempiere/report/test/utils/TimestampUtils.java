package org.bandahealth.idempiere.report.test.utils;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class TimestampUtils {
	public static Timestamp today() {
		Calendar calendar = getCalendarForNow();
		return new Timestamp(calendar.getTimeInMillis());
	}

	public static Timestamp tomorrow() {
		Calendar calendar = getCalendarForNow();
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		return new Timestamp(calendar.getTimeInMillis());
	}

	public static Timestamp endOfTomorrow() {
		Calendar calendar = getCalendarForNow();
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		setTimeToEndofDay(calendar);
		return new Timestamp(calendar.getTimeInMillis());
	}

	public static Timestamp yesterday() {
		Calendar calendar = getCalendarForNow();
		calendar.add(Calendar.DAY_OF_YEAR, -1);
		return new Timestamp(calendar.getTimeInMillis());
	}

	public static Timestamp startOfYesterday() {
		Calendar calendar = getCalendarForNow();
		calendar.add(Calendar.DAY_OF_YEAR, -1);
		setTimeToBeginningOfDay(calendar);
		return new Timestamp(calendar.getTimeInMillis());
	}

	public static Timestamp lastMonth() {
		Calendar calendar = getCalendarForNow();
		calendar.add(Calendar.MONTH, -1);
		return new Timestamp(calendar.getTimeInMillis());
	}

	/**
	 * Adds or subtracts the specified amount of time to the today. For example, to subtract 5 days from
	 * today, you can achieve it by calling:
	 * <p><code>TimestampUtils.addToNow(Calendar.DAY_OF_MONTH, -5)</code>.
	 *
	 * @param field the calendar field.
	 * @param amount the amount of date or time to be added to the field.
	 */
	public static Timestamp addToNow(int field, int amount) {
		Calendar calendar = getCalendarForNow();
		calendar.add(field, amount);
		return new Timestamp(calendar.getTimeInMillis());
	}

	public static Timestamp startOfMonth() {
		Calendar calendar = getCalendarForNow();
		calendar.set(Calendar.DAY_OF_MONTH,
				calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		setTimeToBeginningOfDay(calendar);
		return new Timestamp(calendar.getTimeInMillis());
	}

	public static Timestamp endOfMonth() {
		Calendar calendar = getCalendarForNow();
		calendar.set(Calendar.DAY_OF_MONTH,
				calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		setTimeToEndofDay(calendar);
		return new Timestamp(calendar.getTimeInMillis());
	}

	private static Calendar getCalendarForNow() {
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(new Date());
		return calendar;
	}

	private static void setTimeToBeginningOfDay(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
	}

	private static void setTimeToEndofDay(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
	}
}
