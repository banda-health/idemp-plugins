package org.bandahealth.idempiere.rest.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.HttpHeaders;
import java.io.IOException;

/**
 * Borrowed from Jakob Jenkov
 * http://tutorials.jenkov.com/java-servlets/gzip-servlet-filter.html
 */
public class GZipServletFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		if (acceptsGZipEncoding(httpRequest)) {
			httpResponse.addHeader(HttpHeaders.CONTENT_ENCODING, "gzip");
			GZipServletResponseWrapper gzipResponse = new GZipServletResponseWrapper(httpResponse);
			chain.doFilter(request, gzipResponse);
			gzipResponse.close();
		} else {
			chain.doFilter(request, response);
		}
	}

	private boolean acceptsGZipEncoding(HttpServletRequest httpRequest) {
		String acceptEncoding = httpRequest.getHeader(HttpHeaders.ACCEPT_ENCODING);

		return acceptEncoding != null && acceptEncoding.contains( "gzip");
	}
}
