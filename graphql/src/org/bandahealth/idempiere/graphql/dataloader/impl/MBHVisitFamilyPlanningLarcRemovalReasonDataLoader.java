package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHVisitFamilyPlanningLarcRemovalReason;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MBHVisitFamilyPlanningLarcRemovalReasonDataLoader extends X_BH_Visit_Family_Planning_Larc_Removal_ReasonDataLoader {
	public static String DATALOADER_BH_Visit_Family_Planning_Larc_Removal_Reason_BY_BH_Visit_Family_Planning_ID =
			"BH_VisitFamilyPlanningLarcReasonByFamilyPlanningIdDataLoader";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_BH_Visit_Family_Planning_Larc_Removal_Reason_BY_BH_Visit_Family_Planning_ID,
				DataLoader.newMappedDataLoader(getByFamilyPlanningIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MBHVisitFamilyPlanningLarcRemovalReason>> getByFamilyPlanningIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null,
				MBHVisitFamilyPlanningLarcRemovalReason::getBH_Visit_Family_Planning_ID,
				MBHVisitFamilyPlanningLarcRemovalReason.COLUMNNAME_BH_Visit_Family_Planning_ID, keys);
	}
}
