package org.bandahealth.idempiere.base.utils;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.logging.Level;

import org.compiere.util.CLogger;
import org.compiere.util.DisplayType;
import org.compiere.util.Ini;

/**
 * Log authentication failures with area, device fingerprint, and hashed username.
 *
 * Username is SHA-256 hashed to avoid logging PII.
 * Device fingerprint is a SHA-256 hash of IP + User-Agent + Accept-Language,
 * giving a more specific identifier than IP alone (important for CGNAT environments
 * where many users share a single public IP).
 */
public class BHLogAuthFailure implements Closeable {

	private static BHLogAuthFailure instance;

	private FileOutputStream file;
	private Writer writer;
	public static String authFailureFilename = "AuthFailure.log";
	private static final CLogger log = CLogger.getCLogger(BHLogAuthFailure.class);

	private BHLogAuthFailure() {
		String path = Ini.getAdempiereHome() + File.separator + "log";
		String name = path + File.separator + authFailureFilename;
		try {
			File fileName = new File(name);
			file = new FileOutputStream(fileName, true);
			writer = new BufferedWriter(new OutputStreamWriter(file, StandardCharsets.UTF_8));
		} catch (IOException e) {
			if (log.isLoggable(Level.FINE)) log.fine(e.getMessage());
			e.printStackTrace();
		}
	}

	public static synchronized BHLogAuthFailure getInstance() {
		if (instance == null) {
			instance = new BHLogAuthFailure();
		}
		return instance;
	}

	/**
	 * Log an authentication failure.
	 *
	 * @param clientIP       the client IP address
	 * @param userAgent      the User-Agent header value (may be null)
	 * @param acceptLanguage the Accept-Language header value (may be null)
	 * @param context        the request context path (e.g. "/graphql")
	 * @param username       the username that failed — will be SHA-256 hashed before writing
	 * @param msg            the error message
	 * @param area           the authentication area (e.g. "SignIn", "ChangePassword", "ChangeAccess")
	 */
	public void log(String clientIP, String userAgent, String acceptLanguage, String context, String username,
			String msg, String area) {
		try {
			String fingerprint = sha256(
					clientIP + "|" + (userAgent != null ? userAgent : "") + "|" + (acceptLanguage != null ? acceptLanguage : ""));
			SimpleDateFormat format = DisplayType.getTimestampFormat_Default();
			String dateTimeText = format.format(new Timestamp(System.currentTimeMillis()));

			writer.append("[");
			writer.append(dateTimeText);
			writer.append("] [error] [area ");
			writer.append(area);
			writer.append("] [client ");
			writer.append(clientIP);
			writer.append("] [fingerprint ");
			writer.append(fingerprint);
			writer.append("] [context ");
			writer.append(context);
			writer.append("] [username-hash ");
			writer.append(sha256(username));
			writer.append("] ");
			writer.append(msg);
			writer.append("\n");
			writer.flush();
		} catch (Exception e) {
			if (log.isLoggable(Level.FINE)) log.fine(e.getMessage());
		}
	}

	@Override
	public void close() throws IOException {
		if (writer != null) {
			writer.close();
		}
		if (file != null) {
			file.close();
		}
	}

	public static String sha256(String input) {
		if (input == null) {
			return "unknown";
		}
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
			StringBuilder hex = new StringBuilder();
			for (byte b : hash) {
				hex.append(String.format("%02x", b));
			}
			return hex.toString();
		} catch (NoSuchAlgorithmException e) {
			return "hash-unavailable";
		}
	}
}
