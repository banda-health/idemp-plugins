package org.bandahealth.idempiere.report.test.utils;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimestampUtils {
	public static Timestamp tomorrow() {
		Date date = new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(1));
		return new Timestamp(date.getTime());
	}

	public static Timestamp yesterday() {
		Date date = new Date(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1));
		return new Timestamp(date.getTime());
	}

	public static Timestamp lastMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(System.currentTimeMillis()));
		calendar.add(Calendar.MONTH, -1);
		return new Timestamp(calendar.getTimeInMillis());
	}
}
