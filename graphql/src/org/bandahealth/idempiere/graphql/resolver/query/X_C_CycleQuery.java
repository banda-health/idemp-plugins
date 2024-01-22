package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_Cycle;

/**
 * Generated Query Resolver for C_Cycle - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_CycleQuery extends POQuery<X_C_Cycle> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_Cycle.Table_Name;
	}

	public Connection<X_C_Cycle> C_CycleGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
