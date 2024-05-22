package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCostType;

/**
 * Generated Query Resolver for M_CostType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_CostTypeQuery extends POQuery<MCostType> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCostType.Table_Name;
	}

	public Connection<MCostType> M_CostTypeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
