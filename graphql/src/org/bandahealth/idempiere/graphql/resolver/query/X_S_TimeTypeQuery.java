package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_S_TimeType;

/**
 * Generated Query Resolver for S_TimeType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_S_TimeTypeQuery extends POQuery<X_S_TimeType> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_S_TimeType.Table_Name;
	}

	public Connection<X_S_TimeType> S_TimeTypeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
