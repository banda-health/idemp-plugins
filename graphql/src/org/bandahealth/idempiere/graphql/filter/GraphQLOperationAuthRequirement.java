package org.bandahealth.idempiere.graphql.filter;

/**
 * How strongly a GraphQL operation must be authenticated before it may run.
 */
enum GraphQLOperationAuthRequirement {
	/** May run with no session (SignIn, AD_LanguageGet, etc.). */
	UNAUTHENTICATED,
	/** May run with a valid JWT before client/role selection is complete. */
	PARTIAL,
	/** Requires user, role, and an active session. */
	FULL
}
