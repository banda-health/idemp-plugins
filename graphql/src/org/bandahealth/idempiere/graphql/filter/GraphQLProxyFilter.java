package org.bandahealth.idempiere.graphql.filter;

import org.adempiere.util.ServerContext;
import org.bandahealth.idempiere.graphql.proxy.GraphQLProxyForwarder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * Authenticates and proxies GraphQL requests on /proxy/* before the main GraphQL servlet can handle them.
 */
public class GraphQLProxyFilter implements Filter {

	private static final byte[] UNAUTHORIZED_RESPONSE =
			"{\"errors\":[{\"message\":\"Unauthorized\"}]}".getBytes(StandardCharsets.UTF_8);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// Intentionally left blank
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		ServerContext.setCurrentInstance(new Properties());
		BandaServletRequestWrapper bandaRequest = new BandaServletRequestWrapper(request);
		if (AuthenticationSessionResolver.resolve(bandaRequest) != AuthenticationSessionState.FULL) {
			httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			httpResponse.setContentType("application/json");
			httpResponse.setCharacterEncoding(StandardCharsets.UTF_8.name());
			httpResponse.getOutputStream().write(UNAUTHORIZED_RESPONSE);
			return;
		}

		String method = bandaRequest.getMethod();
		if ("POST".equalsIgnoreCase(method)) {
			GraphQLProxyForwarder.forward(bandaRequest, httpResponse, "POST",
					GraphQLProxyForwarder.readRequestBody(bandaRequest));
			return;
		}
		if ("GET".equalsIgnoreCase(method)) {
			GraphQLProxyForwarder.forward(bandaRequest, httpResponse, "GET", null);
			return;
		}

		httpResponse.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
	}

	@Override
	public void destroy() {
		// Intentionally left blank
	}
}
