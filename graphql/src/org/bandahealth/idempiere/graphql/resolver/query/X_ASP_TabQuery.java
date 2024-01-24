package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_ASP_Tab;

/**
 * Generated Query Resolver for ASP_Tab - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_ASP_TabQuery extends POQuery<X_ASP_Tab> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_ASP_Tab.Table_Name;
	}

	public Connection<X_ASP_Tab> ASP_TabGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
