package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_ASP_Task;

/**
 * Generated Query Resolver for ASP_Task - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_ASP_TaskQuery extends POQuery<X_ASP_Task> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_ASP_Task.Table_Name;
	}

	public Connection<X_ASP_Task> ASP_TaskGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
