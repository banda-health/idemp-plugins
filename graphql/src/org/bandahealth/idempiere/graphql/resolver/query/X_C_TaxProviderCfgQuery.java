package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_TaxProviderCfg;

/**
 * Generated Query Resolver for C_TaxProviderCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_TaxProviderCfgQuery extends POQuery<X_C_TaxProviderCfg> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_TaxProviderCfg.Table_Name;
	}

	public Connection<X_C_TaxProviderCfg> C_TaxProviderCfgGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
