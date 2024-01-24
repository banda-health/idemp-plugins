package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PA_GoalInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_GoalInput;
import org.compiere.model.MGoal;

import java.util.List;

/**
 * Generated Query Resolver for PA_Goal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_PA_GoalMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_GoalInput.Table_Name;
	}

	public MGoal PA_GoalSave(I_PA_GoalInput input, DataFetchingEnvironment environment) {
		return (MGoal) super.save((X_PA_GoalInput) input, environment);
	}

	public boolean PA_GoalDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
