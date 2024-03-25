package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MLandedCostAllocation;

/**
 * Generated Query Resolver for C_LandedCostAllocation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_LandedCostAllocationQuery extends POQuery<MLandedCostAllocation> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MLandedCostAllocation.Table_Name;
	}

	public Connection<MLandedCostAllocation> C_LandedCostAllocationGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
