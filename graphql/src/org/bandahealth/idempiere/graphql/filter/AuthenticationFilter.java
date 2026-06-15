package org.bandahealth.idempiere.graphql.filter;

import org.adempiere.util.ServerContext;
import org.compiere.model.MSystem;
import org.compiere.util.Env;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Basic Authentication on all requests. Batched GraphQL requests are authorized per operation so an
 * allowlisted operation cannot unlock protected operations in the same HTTP request.
 */
public class AuthenticationFilter implements Filter {

	private static final String ERROR_UNAUTHORIZED = "Unauthorized";
	private static final String ERROR_INTERNAL_SERVER_ERROR = "Internal Server Error";
	private static final List<String> ALLOWABLE_UNAUTHENTICATED_QUERIES =
			List.of("SignIn", "ChangePassword", "AD_LanguageGet");
	private static final List<String> ALLOWABLE_PARTIALLY_AUTHENTICATED_QUERIES =
			List.of("ChangeAccess", "AD_ClientGet", "AD_ClientForAccessSelection");
	private static final List<String> ALLOWABLE_UNAUTHENTICATED_NON_PROD_QUERIES = List.of("IntrospectionQuery");

	private GraphQLOperationAuthClassifier operationAuthClassifier;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		operationAuthClassifier = new GraphQLOperationAuthClassifier(ALLOWABLE_UNAUTHENTICATED_QUERIES,
				ALLOWABLE_PARTIALLY_AUTHENTICATED_QUERIES, ALLOWABLE_UNAUTHENTICATED_NON_PROD_QUERIES);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		ServerContext.setCurrentInstance(new Properties());

		BandaServletRequestWrapper bandaRequest = new BandaServletRequestWrapper(request);
		GraphQLBatchRequest batchRequest = GraphQLBatchRequest.parse(bandaRequest);
		boolean isProduction = MSystem.get(Env.getCtx()).getSystemStatus().equals(MSystem.SYSTEMSTATUS_Production);
		AuthenticationSessionState sessionState = resolveSessionState(bandaRequest);

		List<Boolean> allowedOperations = new ArrayList<>();
		List<String> operationErrors = new ArrayList<>();
		for (GraphQLBatchRequest.GraphQLOperation operation : batchRequest.getOperations()) {
			GraphQLOperationAuthRequirement requirement =
					operationAuthClassifier.getRequirement(operation.getQuery(), isProduction);
			if (GraphQLOperationAuthClassifier.isAllowed(requirement, sessionState)) {
				allowedOperations.add(Boolean.TRUE);
				operationErrors.add(null);
			} else {
				allowedOperations.add(Boolean.FALSE);
				operationErrors.add(ERROR_UNAUTHORIZED);
			}
		}

		boolean hasAllowedOperation = allowedOperations.stream().anyMatch(Boolean::booleanValue);
		boolean hasDeniedOperation = allowedOperations.stream().anyMatch(allowed -> !allowed);

		if (!hasAllowedOperation) {
			GraphQLBatchResponseBuilder.writeDeniedBatch(batchRequest, operationErrors, response);
			return;
		}

		if (!hasDeniedOperation) {
			chain.doFilter(bandaRequest, response);
			return;
		}

		List<GraphQLBatchRequest.GraphQLOperation> forwardedOperations = new ArrayList<>();
		for (int index = 0; index < batchRequest.size(); index++) {
			if (allowedOperations.get(index)) {
				forwardedOperations.add(batchRequest.getOperations().get(index));
			}
		}

		BandaServletRequestWrapper forwardedRequest =
				new BandaServletRequestWrapper(bandaRequest, batchRequest.toJsonBytes(forwardedOperations));
		BandaServletResponseWrapper wrappedResponse = new BandaServletResponseWrapper((javax.servlet.http.HttpServletResponse) response);
		chain.doFilter(forwardedRequest, wrappedResponse);

		List<Object> mergedResults =
				GraphQLBatchResponseBuilder.mergeResults(batchRequest, allowedOperations, wrappedResponse.getCapturedBody());
		GraphQLBatchResponseBuilder.writeMergedBatch(response, batchRequest, mergedResults);
	}

	private AuthenticationSessionState resolveSessionState(BandaServletRequestWrapper request) {
		return AuthenticationSessionResolver.resolve(request);
	}

	@Override
	public void destroy() {
		// Intentionally left blank
	}
}
