package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MAchievement;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MAchievementDataLoader extends X_PA_AchievementDataLoader {
	public static String DATALOADER_PA_Achievement_BY_PA_Measure_ID = "DATALOADER_PA_Achievement_BY_PA_Measure_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_PA_Achievement_BY_PA_Measure_ID,
				DataLoader.newMappedDataLoader(getByMeasureIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MAchievement>> getByMeasureIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MAchievement::getPA_Measure_ID,
				MAchievement.COLUMNNAME_PA_Measure_ID, keys);
	}
}
