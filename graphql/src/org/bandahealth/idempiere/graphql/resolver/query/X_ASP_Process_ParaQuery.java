package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_ASP_Process_Para;

/**
 * Generated Query Resolver for ASP_Process_Para - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_ASP_Process_ParaQuery extends POQuery<X_ASP_Process_Para> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_ASP_Process_Para.Table_Name;
	}

	public Connection<X_ASP_Process_Para> ASP_Process_ParaGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
