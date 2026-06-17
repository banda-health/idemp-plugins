package org.bandahealth.idempiere.graphql.proxy;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.adempiere.util.ServerContext;
import org.bandahealth.idempiere.graphql.filter.BandaServletRequestWrapper;
import org.bandahealth.idempiere.graphql.utils.AuthenticationUtil;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.util.CLogger;
import org.compiere.util.Env;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Forwards authenticated GraphQL requests to a configured upstream server.
 */
public class GraphQLProxyForwarder {

	public static final String HEADER_USER_ID = "X-AD-User-ID";
	public static final String HEADER_USER_NAME = "X-AD-User-Name";

	private static final CLogger logger = CLogger.getCLogger(GraphQLProxyForwarder.class);
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	private static final HttpClient HTTP_CLIENT = HttpClient.newBuilder()
			.version(HttpClient.Version.HTTP_1_1)
			.connectTimeout(Duration.ofSeconds(10))
			.build();
	private static final List<String> FORWARDED_REQUEST_HEADERS = List.of(
			"Accept",
			"Accept-Language",
			"Accept-Encoding",
			"X-Request-ID"
	);
	private static final byte[] SERVICE_UNAVAILABLE_RESPONSE =
			"{\"errors\":[{\"message\":\"GraphQL proxy upstream is not configured\"}]}"
					.getBytes(StandardCharsets.UTF_8);
	private static final byte[] BAD_GATEWAY_RESPONSE =
			"{\"errors\":[{\"message\":\"GraphQL proxy upstream request failed\"}]}"
					.getBytes(StandardCharsets.UTF_8);

	private GraphQLProxyForwarder() {
	}

	public static void forward(HttpServletRequest request, HttpServletResponse response, String method, byte[] body)
			throws IOException {
		String upstreamUrl = GraphQLProxyConfig.getUpstreamUrl();
		if (StringUtil.isNullOrEmpty(upstreamUrl)) {
			writeError(response, HttpServletResponse.SC_SERVICE_UNAVAILABLE, SERVICE_UNAVAILABLE_RESPONSE);
			return;
		}

		URI targetUri = buildTargetUri(upstreamUrl, request.getQueryString());
		HttpRequest.Builder requestBuilder = HttpRequest.newBuilder(targetUri)
				.timeout(Duration.ofSeconds(60))
				.method(method, bodyPublisher(method, body));

		copyRequestHeaders(request, requestBuilder);
		addIdentityHeaders(requestBuilder);

		try {
			HttpResponse<InputStream> upstreamResponse =
					HTTP_CLIENT.send(requestBuilder.build(), HttpResponse.BodyHandlers.ofInputStream());
			copyResponse(upstreamResponse, response);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
			logger.warning(ex.getMessage());
			writeError(response, HttpServletResponse.SC_BAD_GATEWAY, BAD_GATEWAY_RESPONSE);
		} catch (IOException ex) {
			logger.warning(ex.getMessage());
			writeError(response, HttpServletResponse.SC_BAD_GATEWAY, BAD_GATEWAY_RESPONSE);
		}
	}

	private static URI buildTargetUri(String upstreamUrl, String queryString) {
		if (StringUtil.isNullOrEmpty(queryString)) {
			return URI.create(upstreamUrl);
		}
		return URI.create(upstreamUrl + (upstreamUrl.contains("?") ? "&" : "?") + queryString);
	}

	private static HttpRequest.BodyPublisher bodyPublisher(String method, byte[] body) {
		if (!"POST".equals(method) || body == null) {
			return HttpRequest.BodyPublishers.noBody();
		}
		return HttpRequest.BodyPublishers.ofByteArray(body);
	}

	private static void copyRequestHeaders(HttpServletRequest request, HttpRequest.Builder requestBuilder) {
		for (String headerName : FORWARDED_REQUEST_HEADERS) {
			String headerValue = request.getHeader(headerName);
			if (!StringUtil.isNullOrEmpty(headerValue)) {
				requestBuilder.header(headerName, headerValue);
			}
		}

		String contentType = request.getContentType();
		if (!StringUtil.isNullOrEmpty(contentType)) {
			requestBuilder.header("Content-Type", contentType);
		}
	}

	private static void addIdentityHeaders(HttpRequest.Builder requestBuilder) {
		var context = ServerContext.getCurrentInstance();
		if (context == null) {
			return;
		}

		addHeaderIfPresent(requestBuilder, HEADER_USER_ID, Env.getContext(context, Env.AD_USER_ID));
		addHeaderIfPresent(requestBuilder, HEADER_USER_NAME, Env.getContext(context, AuthenticationUtil.LOGIN_NAME));
	}

	private static void addHeaderIfPresent(HttpRequest.Builder requestBuilder, String headerName, String headerValue) {
		if (!StringUtil.isNullOrEmpty(headerValue)) {
			requestBuilder.header(headerName, headerValue);
		}
	}

	public static byte[] readRequestBody(HttpServletRequest request) throws IOException {
		if (request instanceof BandaServletRequestWrapper wrapper) {
			byte[] body = wrapper.getBody();
			return body == null ? new byte[0] : body;
		}
		return request.getInputStream().readAllBytes();
	}

	private static void copyResponse(HttpResponse<InputStream> upstreamResponse, HttpServletResponse response)
			throws IOException {
		byte[] upstreamBody;
		try (InputStream upstreamBodyStream = upstreamResponse.body()) {
			upstreamBody = upstreamBodyStream.readAllBytes();
		}

		String contentType = upstreamResponse.headers().firstValue("Content-Type").orElse(null);
		byte[] clientBody = sanitizeResponseBody(upstreamBody, contentType);

		response.resetBuffer();
		response.setStatus(upstreamResponse.statusCode());
		if (!StringUtil.isNullOrEmpty(contentType)) {
			response.setContentType(contentType);
		}
		response.getOutputStream().write(clientBody);
	}

	static byte[] sanitizeResponseBody(byte[] body, String contentType) throws IOException {
		if (body == null || body.length == 0 || StringUtil.isNullOrEmpty(contentType)
				|| !contentType.toLowerCase().contains("application/json")) {
			return body;
		}

		Object parsed = OBJECT_MAPPER.readValue(body, Object.class);
		if (parsed instanceof Map<?, ?> map) {
			return OBJECT_MAPPER.writeValueAsBytes(sanitizeGraphQLPayload(map));
		}
		if (parsed instanceof List<?> list) {
			List<Object> sanitizedResponses = new ArrayList<>();
			for (Object item : list) {
				if (item instanceof Map<?, ?> map) {
					sanitizedResponses.add(sanitizeGraphQLPayload(map));
				} else {
					sanitizedResponses.add(item);
				}
			}
			return OBJECT_MAPPER.writeValueAsBytes(sanitizedResponses);
		}
		return body;
	}

	private static Map<String, Object> sanitizeGraphQLPayload(Map<?, ?> payload) {
		Map<String, Object> sanitized = new LinkedHashMap<>();
		for (Map.Entry<?, ?> entry : payload.entrySet()) {
			if ("extensions".equals(entry.getKey())) {
				continue;
			}
			sanitized.put(String.valueOf(entry.getKey()), entry.getValue());
		}
		return sanitized;
	}

	private static void writeError(HttpServletResponse response, int statusCode, byte[] body) throws IOException {
		response.setStatus(statusCode);
		response.setContentType("application/json");
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		response.getOutputStream().write(body);
	}
}
