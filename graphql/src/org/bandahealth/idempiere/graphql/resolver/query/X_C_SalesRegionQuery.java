package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MSalesRegion;

/**
 * Generated Query Resolver for C_SalesRegion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_SalesRegionQuery extends POQuery<MSalesRegion> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MSalesRegion.Table_Name;
	}

	public Connection<MSalesRegion> C_SalesRegionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
