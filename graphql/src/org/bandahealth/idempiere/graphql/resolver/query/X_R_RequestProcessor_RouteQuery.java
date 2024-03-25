package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRequestProcessorRoute;

/**
 * Generated Query Resolver for R_RequestProcessor_Route - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_RequestProcessor_RouteQuery extends POQuery<MRequestProcessorRoute> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRequestProcessorRoute.Table_Name;
	}

	public Connection<MRequestProcessorRoute> R_RequestProcessor_RouteGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
