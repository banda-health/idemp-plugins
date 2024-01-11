package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_M_Demand;

/**
 * Generated Query Resolver for M_Demand - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_DemandQuery extends POQuery<X_M_Demand> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_M_Demand.Table_Name;
	}

	public Connection<X_M_Demand> M_DemandGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
