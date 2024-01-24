package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_I_ProductPlanningInput;
import org.bandahealth.idempiere.graphql.model.input.X_I_ProductPlanningInput;
import org.eevolution.model.X_I_ProductPlanning;

import java.util.List;

/**
 * Generated Query Resolver for I_ProductPlanning - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_I_ProductPlanningMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_I_ProductPlanningInput.Table_Name;
	}

	public X_I_ProductPlanning I_ProductPlanningSave(I_I_ProductPlanningInput input, DataFetchingEnvironment environment) {
		return (X_I_ProductPlanning) super.save((X_I_ProductPlanningInput) input, environment);
	}

	public boolean I_ProductPlanningDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
