package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_OrderLandedCostAllocationInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_OrderLandedCostAllocationInput;
import org.compiere.model.MOrderLandedCostAllocation;

import java.util.List;

/**
 * Generated Query Resolver for C_OrderLandedCostAllocation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_OrderLandedCostAllocationMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_OrderLandedCostAllocationInput.Table_Name;
	}

	public MOrderLandedCostAllocation C_OrderLandedCostAllocationSave(I_C_OrderLandedCostAllocationInput input, DataFetchingEnvironment environment) {
		return (MOrderLandedCostAllocation) super.save((X_C_OrderLandedCostAllocationInput) input, environment);
	}

	public boolean C_OrderLandedCostAllocationDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
