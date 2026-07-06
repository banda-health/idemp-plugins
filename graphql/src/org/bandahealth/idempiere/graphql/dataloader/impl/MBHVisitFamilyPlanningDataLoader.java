package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHVisitFamilyPlanning;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MBHVisitFamilyPlanningDataLoader extends X_BH_Visit_Family_PlanningDataLoader {
	public static String DATALOADER_BH_Visit_Family_Planning_BY_BH_Visit_ID =
			"BH_VisitFamilyPlanningByVisitIdDataLoader";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_BH_Visit_Family_Planning_BY_BH_Visit_ID,
				DataLoader.newMappedDataLoader(getByVisitIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, MBHVisitFamilyPlanning> getByVisitIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
						batchLoaderEnvironment.getContext(), getTableName(), null, MBHVisitFamilyPlanning::getBH_Visit_ID,
						MBHVisitFamilyPlanning.COLUMNNAME_BH_Visit_ID, keys)
				.thenApply(groups -> groups.entrySet().stream().collect(java.util.stream.Collectors.toMap(
						java.util.Map.Entry::getKey,
						entry -> {
							List<MBHVisitFamilyPlanning> rows = entry.getValue();
							return rows == null || rows.isEmpty() ? null : rows.get(0);
						})));
	}
}
