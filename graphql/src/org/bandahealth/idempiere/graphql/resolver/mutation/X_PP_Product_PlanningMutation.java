package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PP_Product_PlanningInput;
import org.bandahealth.idempiere.graphql.model.input.X_PP_Product_PlanningInput;
import org.eevolution.model.MPPProductPlanning;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for PP_Product_Planning - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PP_Product_PlanningMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PP_Product_PlanningInput.Table_Name;
	}

	public MPPProductPlanning PP_Product_PlanningSave(I_PP_Product_PlanningInput Entity, DataFetchingEnvironment environment) {
		return (MPPProductPlanning) super.save((X_PP_Product_PlanningInput) Entity, environment);
	}

	public List<MPPProductPlanning> PP_Product_PlanningSaveMany(List<I_PP_Product_PlanningInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_PP_Product_PlanningInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MPPProductPlanning) entity).collect(Collectors.toList());
	}

	public boolean PP_Product_PlanningDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
