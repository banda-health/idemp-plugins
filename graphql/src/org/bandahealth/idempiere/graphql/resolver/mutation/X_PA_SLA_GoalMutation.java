package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PA_SLA_GoalInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_SLA_GoalInput;
import org.compiere.model.MSLAGoal;

import java.util.List;

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

	public MSLAGoal PA_SLA_GoalSave(I_PA_SLA_GoalInput input, DataFetchingEnvironment environment) {
		return (MSLAGoal) super.save((X_PA_SLA_GoalInput) input, environment);
	}

	public boolean PA_SLA_GoalDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
