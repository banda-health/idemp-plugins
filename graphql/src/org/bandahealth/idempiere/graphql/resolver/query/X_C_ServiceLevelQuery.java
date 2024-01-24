package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_ServiceLevel;

/**
 * Generated Query Resolver for C_ServiceLevel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ServiceLevelQuery extends POQuery<X_C_ServiceLevel> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_ServiceLevel.Table_Name;
	}

	public Connection<X_C_ServiceLevel> C_ServiceLevelGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
