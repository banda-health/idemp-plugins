package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MReplenish;

/**
 * Generated Query Resolver for M_Replenish - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ReplenishQuery extends POQuery<MReplenish> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MReplenish.Table_Name;
	}

	public Connection<MReplenish> M_ReplenishGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
