package org.bandahealth.idempiere.graphql.proxy;

import org.bandahealth.idempiere.graphql.utils.StringUtil;

/**
 * Configuration for the authenticated GraphQL proxy servlet.
 */
public class GraphQLProxyConfig {

	public static final String ENV_UPSTREAM_URL = "GRAPHQL_PROXY_UPSTREAM_URL";

	private GraphQLProxyConfig() {
	}

	public static String getUpstreamUrl() {
		String upstreamUrl = System.getenv(ENV_UPSTREAM_URL);
		if (StringUtil.isNullOrEmpty(upstreamUrl)) {
			return null;
		}
		return upstreamUrl;
	}
}
