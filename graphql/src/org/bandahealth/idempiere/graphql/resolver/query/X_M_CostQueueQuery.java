package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCostQueue;

/**
 * Generated Query Resolver for M_CostQueue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_CostQueueQuery extends POQuery<MCostQueue> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCostQueue.Table_Name;
	}

	public Connection<MCostQueue> M_CostQueueGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
