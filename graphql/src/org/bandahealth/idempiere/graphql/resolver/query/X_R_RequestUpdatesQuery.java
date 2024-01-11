package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_R_RequestUpdates;

/**
 * Generated Query Resolver for R_RequestUpdates - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_RequestUpdatesQuery extends POQuery<X_R_RequestUpdates> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_R_RequestUpdates.Table_Name;
	}

	public Connection<X_R_RequestUpdates> R_RequestUpdatesGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
