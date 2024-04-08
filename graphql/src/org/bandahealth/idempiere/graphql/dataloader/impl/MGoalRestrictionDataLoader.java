package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MGoalRestriction;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MGoalRestrictionDataLoader extends X_PA_GoalRestrictionDataLoader {
	public static String DATALOADER_PA_GoalRestriction_BY_PA_Goal_ID = "DATALOADER_PA_GoalRestriction_BY_PA_Goal_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_PA_GoalRestriction_BY_PA_Goal_ID,
				DataLoader.newMappedDataLoader(getByGoalIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MGoalRestriction>> getByGoalIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MGoalRestriction::getPA_Goal_ID,
				MGoalRestriction.COLUMNNAME_PA_Goal_ID, keys);
	}
}
