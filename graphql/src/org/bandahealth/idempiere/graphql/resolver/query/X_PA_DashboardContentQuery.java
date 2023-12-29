package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDashboardContent;

/**
 * Generated Query Resolver for PA_DashboardContent - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_DashboardContentQuery extends POQuery<MDashboardContent> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDashboardContent.Table_Name;
	}

	public Connection<MDashboardContent> PA_DashboardContentGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
