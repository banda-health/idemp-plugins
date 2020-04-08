package org.bandahealth.idempiere.rest.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.compiere.util.CLogger;

public class DateUtil {

	private final static String DEFAULT_FORMAT = "yyyy-MM-dd hh:mm:ss";
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
	 * @param timestamp
	 * @return
	 */
	public static String parseQueueTime(Timestamp timestamp) {
		if (timestamp != null) {
			return new SimpleDateFormat(QUEUE_DATE_FORMAT).format(timestamp);
		}

		return null;

	}

	public static Timestamp getTimestamp(String date) {
		if (date != null) {
			try {
				return new Timestamp(sdf.parse(date).getTime());
			} catch (ParseException e) {
				log.severe(e.getMessage());
			}
		}

		return null;
	}
}
