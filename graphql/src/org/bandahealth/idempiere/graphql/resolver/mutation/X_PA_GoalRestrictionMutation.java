package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PA_GoalRestrictionInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_GoalRestrictionInput;
import org.compiere.model.MGoalRestriction;

import java.util.List;

/**
 * Generated Query Resolver for PA_GoalRestriction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_PA_GoalRestrictionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_GoalRestrictionInput.Table_Name;
	}

	public MGoalRestriction PA_GoalRestrictionSave(I_PA_GoalRestrictionInput input, DataFetchingEnvironment environment) {
		return (MGoalRestriction) super.save((X_PA_GoalRestrictionInput) input, environment);
	}

	public boolean PA_GoalRestrictionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
