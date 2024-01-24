package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PA_SLA_GoalInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_SLA_GoalInput;
import org.compiere.model.MSLAGoal;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for PA_SLA_Goal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_SLA_GoalMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_SLA_GoalInput.Table_Name;
	}

	public MSLAGoal PA_SLA_GoalSave(I_PA_SLA_GoalInput entity, DataFetchingEnvironment environment) {
		return (MSLAGoal) super.save((X_PA_SLA_GoalInput) entity, environment);
	}

	public List<MSLAGoal> PA_SLA_GoalSaveMany(List<I_PA_SLA_GoalInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_PA_SLA_GoalInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MSLAGoal) entity).collect(Collectors.toList());
	}

	public boolean PA_SLA_GoalDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
