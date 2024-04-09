package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_ProductionPlanInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ProductionPlanInput;
import org.compiere.model.MProductionPlan;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_ProductionPlan - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_ProductionPlanMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ProductionPlanInput.Table_Name;
	}

	public MProductionPlan M_ProductionPlanSave(I_M_ProductionPlanInput Entity, DataFetchingEnvironment environment) {
		return (MProductionPlan) super.save((X_M_ProductionPlanInput) Entity, environment);
	}

	public List<MProductionPlan> M_ProductionPlanSaveMany(List<I_M_ProductionPlanInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_ProductionPlanInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MProductionPlan) entity).collect(Collectors.toList());
	}

	public boolean M_ProductionPlanDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
