package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MProjectTypePhase;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MProjectTypePhaseDataLoader extends X_C_PhaseDataLoader {
	public static String DATALOADER_C_Phase_BY_C_ProjectType_ID = "DATALOADER_C_Phase_BY_C_ProjectType_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_C_Phase_BY_C_ProjectType_ID,
				DataLoader.newMappedDataLoader(getByProjectTypeIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MProjectTypePhase>> getByProjectTypeIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MProjectTypePhase::getC_ProjectType_ID,
				MProjectTypePhase.COLUMNNAME_C_ProjectType_ID, keys);
	}
}
