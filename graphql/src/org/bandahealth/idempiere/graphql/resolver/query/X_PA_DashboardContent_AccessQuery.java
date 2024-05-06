package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDashboardContentAccess;

/**
 * Generated Query Resolver for PA_DashboardContent_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_DashboardContent_AccessQuery extends POQuery<MDashboardContentAccess> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDashboardContentAccess.Table_Name;
	}

	public Connection<MDashboardContentAccess> PA_DashboardContent_AccessGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
