package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MOrderLandedCostAllocation;

/**
 * Generated Query Resolver for C_OrderLandedCostAllocation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_OrderLandedCostAllocationQuery extends POQuery<MOrderLandedCostAllocation> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MOrderLandedCostAllocation.Table_Name;
	}

	public Connection<MOrderLandedCostAllocation> C_OrderLandedCostAllocationGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
