package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_A_Asset_Split;

/**
 * Generated Query Resolver for A_Asset_Split - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Asset_SplitQuery extends POQuery<X_A_Asset_Split> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_A_Asset_Split.Table_Name;
	}

	public Connection<X_A_Asset_Split> A_Asset_SplitGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
