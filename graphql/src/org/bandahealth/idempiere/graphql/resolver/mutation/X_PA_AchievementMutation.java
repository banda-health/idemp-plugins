package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PA_AchievementInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_AchievementInput;
import org.compiere.model.MAchievement;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for PA_Achievement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_AchievementMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_AchievementInput.Table_Name;
	}

	public MAchievement PA_AchievementSave(I_PA_AchievementInput entity, DataFetchingEnvironment environment) {
		return (MAchievement) super.save((X_PA_AchievementInput) entity, environment);
	}

	public List<MAchievement> PA_AchievementSaveMany(List<I_PA_AchievementInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_PA_AchievementInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MAchievement) entity).collect(Collectors.toList());
	}

	public boolean PA_AchievementDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
