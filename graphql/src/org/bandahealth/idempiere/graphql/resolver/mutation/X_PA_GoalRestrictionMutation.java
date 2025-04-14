package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PA_GoalRestrictionInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_GoalRestrictionInput;
import org.compiere.model.MGoalRestriction;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for PA_GoalRestriction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_PA_GoalRestrictionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_GoalRestrictionInput.Table_Name;
	}

	public MGoalRestriction PA_GoalRestrictionSave(I_PA_GoalRestrictionInput Entity, DataFetchingEnvironment environment) {
		return (MGoalRestriction) super.save((X_PA_GoalRestrictionInput) Entity, environment);
	}

	public List<MGoalRestriction> PA_GoalRestrictionSaveMany(List<I_PA_GoalRestrictionInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_PA_GoalRestrictionInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MGoalRestriction) entity).collect(Collectors.toList());
	}

	public boolean PA_GoalRestrictionDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
