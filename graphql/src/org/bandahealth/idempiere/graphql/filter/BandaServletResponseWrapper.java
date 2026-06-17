package org.bandahealth.idempiere.graphql.filter;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * Captures the servlet response body so batch auth errors can be merged with GraphQL results.
 */
class BandaServletResponseWrapper extends HttpServletResponseWrapper {

	private final ByteArrayOutputStream captureStream = new ByteArrayOutputStream();
	private ServletOutputStream outputStream;
	private PrintWriter writer;

	BandaServletResponseWrapper(HttpServletResponse response) {
		super(response);
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		if (writer != null) {
			throw new IllegalStateException("getWriter() has already been called on this response.");
		}
		if (outputStream == null) {
			outputStream = new ServletOutputStream() {
				@Override
				public boolean isReady() {
					return true;
				}

				@Override
				public void setWriteListener(WriteListener listener) {
				}

				@Override
				public void write(int b) {
					captureStream.write(b);
				}
			};
		}
		return outputStream;
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		if (outputStream != null) {
			throw new IllegalStateException("getOutputStream() has already been called on this response.");
		}
		if (writer == null) {
			writer = new PrintWriter(new OutputStreamWriter(captureStream, StandardCharsets.UTF_8));
		}
		return writer;
	}

	byte[] getCapturedBody() throws IOException {
		if (writer != null) {
			writer.flush();
		}
		if (outputStream != null) {
			outputStream.flush();
		}
		return captureStream.toByteArray();
	}

	void writeCapturedBodyToResponse() throws IOException {
		byte[] body = getCapturedBody();
		if (body.length == 0) {
			return;
		}
		ServletOutputStream responseOutputStream = super.getOutputStream();
		responseOutputStream.write(body);
		responseOutputStream.flush();
	}
}
