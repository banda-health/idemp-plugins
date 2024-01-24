package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PP_Product_PlanningInput;
import org.bandahealth.idempiere.graphql.model.input.X_PP_Product_PlanningInput;
import org.eevolution.model.MPPProductPlanning;

import java.util.List;

/**
 * Generated Query Resolver for PP_Product_Planning - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_Product_PlanningMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PP_Product_PlanningInput.Table_Name;
	}

	public MPPProductPlanning PP_Product_PlanningSave(I_PP_Product_PlanningInput input, DataFetchingEnvironment environment) {
		return (MPPProductPlanning) super.save((X_PP_Product_PlanningInput) input, environment);
	}

	public boolean PP_Product_PlanningDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
