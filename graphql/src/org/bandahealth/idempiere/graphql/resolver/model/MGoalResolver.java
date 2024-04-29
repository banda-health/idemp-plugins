package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MGoalRestrictionDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MGoal;
import org.compiere.model.MGoalRestriction;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MGoalResolver extends X_PA_GoalResolver {

	public CompletableFuture<List<MGoalRestriction>> PA_GoalRestrictions(MGoal entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MGoalRestriction>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MGoalRestrictionDataLoader.DATALOADER_PA_GoalRestriction_BY_PA_Goal_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getPA_Goal_ID()));
	}
}
