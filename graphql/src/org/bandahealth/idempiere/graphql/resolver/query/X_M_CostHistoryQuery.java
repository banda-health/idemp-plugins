package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_M_CostHistory;

/**
 * Generated Query Resolver for M_CostHistory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_CostHistoryQuery extends POQuery<X_M_CostHistory> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_M_CostHistory.Table_Name;
	}

	public Connection<X_M_CostHistory> M_CostHistoryGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
