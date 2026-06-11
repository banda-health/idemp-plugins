package org.bandahealth.idempiere.graphql.filter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bandahealth.idempiere.graphql.utils.StringUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * A GraphQL HTTP request containing one or more operations (Apollo batch or single).
 */
class GraphQLBatchRequest {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
			.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

	private final List<GraphQLOperation> operations;
	private final boolean batched;

	private GraphQLBatchRequest(List<GraphQLOperation> operations, boolean batched) {
		this.operations = operations;
		this.batched = batched;
	}

	static GraphQLBatchRequest parse(BandaServletRequestWrapper request) throws IOException {
		String queryParameter = request.getParameter("query");
		if (!StringUtil.isNullOrEmpty(queryParameter)) {
			return new GraphQLBatchRequest(
					Collections.singletonList(new GraphQLOperation(
							Collections.singletonMap("query", queryParameter), queryParameter)), false);
		}

		byte[] body = request.getBody();
		if (body == null || body.length == 0) {
			return new GraphQLBatchRequest(
					Collections.singletonList(new GraphQLOperation(Collections.emptyMap(), "")), false);
		}

		Object parsed = OBJECT_MAPPER.readValue(body, Object.class);
		if (parsed instanceof List) {
			List<?> operationList = (List<?>) parsed;
			List<GraphQLOperation> operations = new ArrayList<>();
			for (Object operation : operationList) {
				if (operation instanceof Map) {
					@SuppressWarnings("unchecked")
					Map<String, Object> typedOperation = (Map<String, Object>) operation;
					operations.add(new GraphQLOperation(typedOperation, stringValue(typedOperation.get("query"))));
				}
			}
			return new GraphQLBatchRequest(operations, true);
		}
		if (parsed instanceof Map) {
			@SuppressWarnings("unchecked")
			Map<String, Object> typedOperation = (Map<String, Object>) parsed;
			return new GraphQLBatchRequest(
					Collections.singletonList(
							new GraphQLOperation(typedOperation, stringValue(typedOperation.get("query")))), false);
		}
		return new GraphQLBatchRequest(Collections.emptyList(), false);
	}

	List<GraphQLOperation> getOperations() {
		return operations;
	}

	boolean isBatched() {
		return batched;
	}

	int size() {
		return operations.size();
	}

	byte[] toJsonBytes(List<GraphQLOperation> operationsToForward) throws IOException {
		List<Map<String, Object>> rawOperations = new ArrayList<>();
		for (GraphQLOperation operation : operationsToForward) {
			rawOperations.add(operation.getRaw());
		}
		if (batched || rawOperations.size() > 1) {
			return OBJECT_MAPPER.writeValueAsBytes(rawOperations);
		}
		return OBJECT_MAPPER.writeValueAsBytes(rawOperations.get(0));
	}

	private static String stringValue(Object value) {
		return value == null ? "" : value.toString();
	}

	static class GraphQLOperation {
		private final Map<String, Object> raw;
		private final String query;

		GraphQLOperation(Map<String, Object> raw, String query) {
			this.raw = raw;
			this.query = query;
		}

		String getQuery() {
			return query;
		}

		Map<String, Object> getRaw() {
			return raw;
		}
	}
}
