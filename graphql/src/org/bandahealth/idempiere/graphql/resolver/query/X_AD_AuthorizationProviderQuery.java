package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAuthorizationProvider;

/**
 * Generated Query Resolver for AD_AuthorizationProvider - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_AuthorizationProviderQuery extends POQuery<MAuthorizationProvider> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAuthorizationProvider.Table_Name;
	}

	public Connection<MAuthorizationProvider> AD_AuthorizationProviderGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
