package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PA_GoalInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_GoalInput;
import org.compiere.model.MGoal;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for PA_Goal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_PA_GoalMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_GoalInput.Table_Name;
	}

	public MGoal PA_GoalSave(I_PA_GoalInput Entity, DataFetchingEnvironment environment) {
		return (MGoal) super.save((X_PA_GoalInput) Entity, environment);
	}

	public List<MGoal> PA_GoalSaveMany(List<I_PA_GoalInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_PA_GoalInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MGoal) entity).collect(Collectors.toList());
	}

	public boolean PA_GoalDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
