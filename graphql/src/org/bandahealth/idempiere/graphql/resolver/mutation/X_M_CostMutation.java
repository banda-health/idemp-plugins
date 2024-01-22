package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_CostInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_CostInput;
import org.compiere.model.MCost;

import java.util.List;

/**
 * Generated Query Resolver for M_Cost - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_CostMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_CostInput.Table_Name;
	}

	public MCost M_CostSave(I_M_CostInput input, DataFetchingEnvironment environment) {
		return (MCost) super.save((X_M_CostInput) input, environment);
	}

	public boolean M_CostDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
