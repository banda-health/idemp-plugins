package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_ASP_Process;

/**
 * Generated Query Resolver for ASP_Process - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_ASP_ProcessQuery extends POQuery<X_ASP_Process> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_ASP_Process.Table_Name;
	}

	public Connection<X_ASP_Process> ASP_ProcessGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
