package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MOrderLandedCostAllocation;

/**
 * Generated Query Resolver for C_OrderLandedCostAllocation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_OrderLandedCostAllocationQuery extends POQuery<MOrderLandedCostAllocation> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MOrderLandedCostAllocation.Table_Name;
	}

	public Connection<MOrderLandedCostAllocation> C_OrderLandedCostAllocationGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
