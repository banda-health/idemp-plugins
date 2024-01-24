package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_A_Asset_Retirement;

/**
 * Generated Query Resolver for A_Asset_Retirement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_RetirementQuery extends POQuery<X_A_Asset_Retirement> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_A_Asset_Retirement.Table_Name;
	}

	public Connection<X_A_Asset_Retirement> A_Asset_RetirementGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
