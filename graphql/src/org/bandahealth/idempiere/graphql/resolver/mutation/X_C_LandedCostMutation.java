package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_LandedCostInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_LandedCostInput;
import org.compiere.model.MLandedCost;

import java.util.List;

/**
 * Generated Query Resolver for C_LandedCost - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_LandedCostMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_LandedCostInput.Table_Name;
	}

	public MLandedCost C_LandedCostSave(I_C_LandedCostInput input, DataFetchingEnvironment environment) {
		return (MLandedCost) super.save((X_C_LandedCostInput) input, environment);
	}

	public boolean C_LandedCostDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
