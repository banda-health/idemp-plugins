package org.bandahealth.idempiere.graphql.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bandahealth.idempiere.graphql.utils.StringUtil;

import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Builds single-operation and batched GraphQL error responses for denied operations.
 */
class GraphQLBatchResponseBuilder {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	private GraphQLBatchResponseBuilder() {
	}

	static void writeDeniedBatch(GraphQLBatchRequest batchRequest, List<String> errorMessages,
			ServletResponse response) throws IOException {
		List<Map<String, Object>> results = new ArrayList<>();
		for (int index = 0; index < batchRequest.size(); index++) {
			String errorMessage = errorMessages.get(index);
			results.add(buildErrorResult(batchRequest.getOperations().get(index).getQuery(),
					errorMessage == null ? "Unauthorized" : errorMessage));
		}
		writeJson(response, batchRequest.isBatched() || batchRequest.size() > 1 ? results : results.get(0));
	}

	static Map<String, Object> buildUnauthorizedResult(String query) {
		return buildErrorResult(query, "Unauthorized");
	}

	private static Map<String, Object> buildErrorResult(String query, String errorMessage) {
		Map<String, Object> result = new LinkedHashMap<>();
		result.put("data", null);
		if (!StringUtil.isNullOrEmpty(errorMessage)) {
			Map<String, Object> error = new LinkedHashMap<>();
			error.put("message", errorMessage);
			String operationName = GraphQLOperationAuthClassifier.extractOperationName(query);
			error.put("paths", Collections.singletonList(operationName));
			result.put("errors", Collections.singletonList(error));
		}
		return result;
	}

	static List<Object> mergeResults(GraphQLBatchRequest originalBatchRequest, List<Boolean> allowedOperations,
			byte[] servletResponseBody) throws IOException {
		List<Object> servletResults = parseServletResults(servletResponseBody);
		List<Object> mergedResults = new ArrayList<>();
		int servletResultIndex = 0;
		for (int index = 0; index < originalBatchRequest.size(); index++) {
			if (allowedOperations.get(index)) {
				mergedResults.add(servletResults.get(servletResultIndex++));
			} else {
				mergedResults.add(buildUnauthorizedResult(originalBatchRequest.getOperations().get(index).getQuery()));
			}
		}
		return mergedResults;
	}

	private static List<Object> parseServletResults(byte[] servletResponseBody) throws IOException {
		if (servletResponseBody == null || servletResponseBody.length == 0) {
			return Collections.emptyList();
		}
		Object parsed = OBJECT_MAPPER.readValue(servletResponseBody, Object.class);
		if (parsed instanceof List) {
			return new ArrayList<>((List<?>) parsed);
		}
		return Collections.singletonList(parsed);
	}

	private static void writeJson(ServletResponse response, Object payload) throws IOException {
		response.setContentType("application/json");
		response.getWriter().write(OBJECT_MAPPER.writeValueAsString(payload));
	}

	static void writeMergedBatch(ServletResponse response, GraphQLBatchRequest originalBatchRequest,
			List<Object> mergedResults) throws JsonProcessingException, IOException {
		Object payload = originalBatchRequest.isBatched() || mergedResults.size() > 1 ? mergedResults :
				mergedResults.isEmpty() ? Collections.emptyMap() : mergedResults.get(0);
		writeJson(response, payload);
	}
}
