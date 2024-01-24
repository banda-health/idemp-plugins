package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_LandedCostAllocationInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_LandedCostAllocationInput;
import org.compiere.model.MLandedCostAllocation;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_LandedCostAllocation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_LandedCostAllocationMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_LandedCostAllocationInput.Table_Name;
	}

	public MLandedCostAllocation C_LandedCostAllocationSave(I_C_LandedCostAllocationInput entity, DataFetchingEnvironment environment) {
		return (MLandedCostAllocation) super.save((X_C_LandedCostAllocationInput) entity, environment);
	}

	public List<MLandedCostAllocation> C_LandedCostAllocationSaveMany(List<I_C_LandedCostAllocationInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_LandedCostAllocationInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MLandedCostAllocation) entity).collect(Collectors.toList());
	}

	public boolean C_LandedCostAllocationDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
