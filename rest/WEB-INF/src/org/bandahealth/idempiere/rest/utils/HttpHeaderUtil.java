package org.bandahealth.idempiere.rest.utils;

import javax.ws.rs.core.Response;

public class HttpHeaderUtil {
	/**
	 * Set the content disposition header on a response for a given file
	 *
	 * @param builder  The response builder to set the header on
	 * @param fileName The filename to use in the header
	 */
	public static void setContentDisposition(Response.ResponseBuilder builder, String fileName) {
		builder.header("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
	}
}
