package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_CashPlanInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_CashPlanInput;
import org.compiere.model.MCashPlan;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_CashPlan - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_CashPlanMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_CashPlanInput.Table_Name;
	}

	public MCashPlan C_CashPlanSave(I_C_CashPlanInput Entity, DataFetchingEnvironment environment) {
		return (MCashPlan) super.save((X_C_CashPlanInput) Entity, environment);
	}

	public List<MCashPlan> C_CashPlanSaveMany(List<I_C_CashPlanInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_CashPlanInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MCashPlan) entity).collect(Collectors.toList());
	}

	public boolean C_CashPlanDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
