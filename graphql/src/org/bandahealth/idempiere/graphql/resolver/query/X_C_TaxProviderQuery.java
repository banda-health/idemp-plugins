package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTaxProvider;

/**
 * Generated Query Resolver for C_TaxProvider - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_TaxProviderQuery extends POQuery<MTaxProvider> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTaxProvider.Table_Name;
	}

	public Connection<MTaxProvider> C_TaxProviderGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
