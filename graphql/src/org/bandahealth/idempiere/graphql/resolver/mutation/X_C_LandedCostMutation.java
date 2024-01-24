package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_LandedCostInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_LandedCostInput;
import org.compiere.model.MLandedCost;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_LandedCost - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_LandedCostMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_LandedCostInput.Table_Name;
	}

	public MLandedCost C_LandedCostSave(I_C_LandedCostInput entity, DataFetchingEnvironment environment) {
		return (MLandedCost) super.save((X_C_LandedCostInput) entity, environment);
	}

	public List<MLandedCost> C_LandedCostSaveMany(List<I_C_LandedCostInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_LandedCostInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MLandedCost) entity).collect(Collectors.toList());
	}

	public boolean C_LandedCostDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
