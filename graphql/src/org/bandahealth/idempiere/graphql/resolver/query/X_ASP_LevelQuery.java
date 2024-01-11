package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_ASP_Level;

/**
 * Generated Query Resolver for ASP_Level - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_ASP_LevelQuery extends POQuery<X_ASP_Level> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_ASP_Level.Table_Name;
	}

	public Connection<X_ASP_Level> ASP_LevelGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
