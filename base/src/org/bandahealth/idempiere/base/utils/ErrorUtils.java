package org.bandahealth.idempiere.base.utils;

import java.util.Date;

public class ErrorUtils {

	public static String NO_LINE_ITEMS_ENTERED_ERROR_MESSAGE_UUID = "03cb65e5-104c-4dd6-bec0-4bfe244ae804";

	public static String createHtmlBody(String error, String clientName) {
		StringBuilder output = new StringBuilder(
				"&nbsp;Date:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		output.append(new Date());
		output.append("<br/>");
		output.append("&nbsp;Client:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		output.append(clientName);
		output.append("<br/>");
		output.append("&nbsp;Error:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		output.append(error);
		output.append("<br /><br />");
		output.append("&nbsp;<b>Kindly check logs for a complete description of this error message.</b>");
		output.append("<br /><br />");
		output.append("&nbsp;Regards, <br />");
		output.append("&nbsp;Banda Health Team");

		return output.toString();
	}
}
