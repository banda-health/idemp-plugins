package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MProjectLine;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MProjectLineDataLoader extends X_C_ProjectLineDataLoader {
	public static String DATALOADER_C_ProjectLine_BY_C_ProjectPhase_ID = "DATALOADER_C_ProjectLine_BY_C_ProjectPhase_ID";
	public static String DATALOADER_C_ProjectLine_BY_C_Project_ID = "DATALOADER_C_ProjectLine_BY_C_Project_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_C_ProjectLine_BY_C_ProjectPhase_ID,
				DataLoader.newMappedDataLoader(getByProjectPhaseIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
		registry.register(DATALOADER_C_ProjectLine_BY_C_Project_ID,
				DataLoader.newMappedDataLoader(getByProjectIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MProjectLine>> getByProjectPhaseIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MProjectLine::getC_ProjectPhase_ID,
				MProjectLine.COLUMNNAME_C_ProjectPhase_ID, keys);
	}

	private MappedBatchLoaderWithContext<String, List<MProjectLine>> getByProjectIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MProjectLine::getC_Project_ID,
				MProjectLine.COLUMNNAME_C_Project_ID, keys);
	}
}
