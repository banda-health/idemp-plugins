package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_ProductionPlanInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ProductionPlanInput;
import org.compiere.model.MProductionPlan;

import java.util.List;

/**
 * Generated Query Resolver for M_ProductionPlan - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ProductionPlanMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ProductionPlanInput.Table_Name;
	}

	public MProductionPlan M_ProductionPlanSave(I_M_ProductionPlanInput input, DataFetchingEnvironment environment) {
		return (MProductionPlan) super.save((X_M_ProductionPlanInput) input, environment);
	}

	public boolean M_ProductionPlanDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
