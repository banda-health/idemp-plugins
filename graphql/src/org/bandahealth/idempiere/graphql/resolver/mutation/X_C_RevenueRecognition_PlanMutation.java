package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_RevenueRecognition_PlanInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_RevenueRecognition_PlanInput;
import org.compiere.model.MRevenueRecognitionPlan;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_RevenueRecognition_Plan - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_RevenueRecognition_PlanMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_RevenueRecognition_PlanInput.Table_Name;
	}

	public MRevenueRecognitionPlan C_RevenueRecognition_PlanSave(I_C_RevenueRecognition_PlanInput Entity, DataFetchingEnvironment environment) {
		return (MRevenueRecognitionPlan) super.save((X_C_RevenueRecognition_PlanInput) Entity, environment);
	}

	public List<MRevenueRecognitionPlan> C_RevenueRecognition_PlanSaveMany(List<I_C_RevenueRecognition_PlanInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_RevenueRecognition_PlanInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MRevenueRecognitionPlan) entity).collect(Collectors.toList());
	}

	public boolean C_RevenueRecognition_PlanDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
