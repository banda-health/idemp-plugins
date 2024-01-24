package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PA_AchievementInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_AchievementInput;
import org.compiere.model.MAchievement;

import java.util.List;

/**
 * Generated Query Resolver for PA_Achievement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_PA_AchievementMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_AchievementInput.Table_Name;
	}

	public MAchievement PA_AchievementSave(I_PA_AchievementInput input, DataFetchingEnvironment environment) {
		return (MAchievement) super.save((X_PA_AchievementInput) input, environment);
	}

	public boolean PA_AchievementDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
