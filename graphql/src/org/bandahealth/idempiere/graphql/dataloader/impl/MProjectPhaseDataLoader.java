package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MProjectPhase;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MProjectPhaseDataLoader extends X_C_ProjectPhaseDataLoader {
	public static String DATALOADER_C_ProjectPhase_BY_C_Project_ID = "DATALOADER_C_ProjectPhase_BY_C_Project_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_C_ProjectPhase_BY_C_Project_ID,
				DataLoader.newMappedDataLoader(getByProjectIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MProjectPhase>> getByProjectIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MProjectPhase::getC_Project_ID,
				MProjectPhase.COLUMNNAME_C_Project_ID, keys);
	}
}
