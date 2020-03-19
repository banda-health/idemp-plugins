package org.bandahealth.idempiere.rest.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.compiere.util.CLogger;

public class DateUtil {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	private static CLogger log = CLogger.getCLogger(DateUtil.class);

	public static String parse(Timestamp timestamp) {
		if (timestamp != null) {
			return sdf.format(timestamp);
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
