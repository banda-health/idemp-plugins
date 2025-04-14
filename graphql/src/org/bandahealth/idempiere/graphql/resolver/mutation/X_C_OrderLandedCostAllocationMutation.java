package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_OrderLandedCostAllocationInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_OrderLandedCostAllocationInput;
import org.compiere.model.MOrderLandedCostAllocation;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_OrderLandedCostAllocation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_OrderLandedCostAllocationMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_OrderLandedCostAllocationInput.Table_Name;
	}

	public MOrderLandedCostAllocation C_OrderLandedCostAllocationSave(I_C_OrderLandedCostAllocationInput Entity, DataFetchingEnvironment environment) {
		return (MOrderLandedCostAllocation) super.save((X_C_OrderLandedCostAllocationInput) Entity, environment);
	}

	public List<MOrderLandedCostAllocation> C_OrderLandedCostAllocationSaveMany(List<I_C_OrderLandedCostAllocationInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_OrderLandedCostAllocationInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MOrderLandedCostAllocation) entity).collect(Collectors.toList());
	}

	public boolean C_OrderLandedCostAllocationDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
