package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_S_TimeType;

/**
 * Generated Query Resolver for S_TimeType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_S_TimeTypeQuery extends POQuery<X_S_TimeType> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_S_TimeType.Table_Name;
	}

	public Connection<X_S_TimeType> S_TimeTypeGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
