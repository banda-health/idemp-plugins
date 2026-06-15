package org.bandahealth.idempiere.graphql.filter;

/**
 * The authentication state derived from the request cookie, if any.
 */
enum AuthenticationSessionState {
	/** No cookie, invalid JWT, or JWT without a user. */
	NONE,
	/** Valid JWT with a user but without a complete role/session. */
	PARTIAL,
	/** Valid JWT with user, role, and an active session. */
	FULL
}
