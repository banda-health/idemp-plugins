package org.bandahealth.idempiere.graphql.filter;

import org.bandahealth.idempiere.graphql.utils.StringUtil;

import java.util.Arrays;
import java.util.List;

/**
 * Determines the authentication requirement for a GraphQL operation string.
 */
class GraphQLOperationAuthClassifier {

	private final List<String> allowableUnauthenticatedQueries;
	private final List<String> allowablePartiallyAuthenticatedQueries;
	private final List<String> allowableUnauthenticatedNonProdQueries;

	GraphQLOperationAuthClassifier(List<String> allowableUnauthenticatedQueries,
			List<String> allowablePartiallyAuthenticatedQueries,
			List<String> allowableUnauthenticatedNonProdQueries) {
		this.allowableUnauthenticatedQueries = allowableUnauthenticatedQueries;
		this.allowablePartiallyAuthenticatedQueries = allowablePartiallyAuthenticatedQueries;
		this.allowableUnauthenticatedNonProdQueries = allowableUnauthenticatedNonProdQueries;
	}

	GraphQLOperationAuthRequirement getRequirement(String query, boolean isProduction) {
		if (StringUtil.isNullOrEmpty(query)) {
			return GraphQLOperationAuthRequirement.FULL;
		}
		if (!isProduction) {
			for (String allowableQuery : allowableUnauthenticatedNonProdQueries) {
				if (query.contains("query " + allowableQuery + " {") || query.contains("query " + allowableQuery + "{")) {
					return GraphQLOperationAuthRequirement.UNAUTHENTICATED;
				}
			}
		}
		for (String allowableQuery : allowableUnauthenticatedQueries) {
			if (query.contains(allowableQuery + "(")) {
				return GraphQLOperationAuthRequirement.UNAUTHENTICATED;
			}
		}
		for (String allowableQuery : allowablePartiallyAuthenticatedQueries) {
			if (query.contains(allowableQuery)) {
				return GraphQLOperationAuthRequirement.PARTIAL;
			}
		}
		return GraphQLOperationAuthRequirement.FULL;
	}

	static String extractOperationName(String query) {
		if (StringUtil.isNullOrEmpty(query)) {
			return "unknown";
		}
		return Arrays.stream(StringUtil.stripNewLines(query).replace("mutation", "").replace(":", " ").replace("(", " ")
				.replace("{", " ").replace("$", " ").replace("!", " ").replace("query", "").split(" "))
				.filter(s -> !StringUtil.isNullOrEmpty(s)).findFirst().orElse("unknown");
	}

	static boolean isAllowed(GraphQLOperationAuthRequirement requirement, AuthenticationSessionState sessionState) {
		if (requirement == GraphQLOperationAuthRequirement.UNAUTHENTICATED) {
			return true;
		}
		if (requirement == GraphQLOperationAuthRequirement.PARTIAL) {
			return sessionState == AuthenticationSessionState.PARTIAL || sessionState == AuthenticationSessionState.FULL;
		}
		return sessionState == AuthenticationSessionState.FULL;
	}
}
