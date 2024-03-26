package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MMovementLineDataLoader extends X_M_MovementLineDataLoader {
	public static String DATALOADER_M_MovementLine_BY_M_Movement_ID = "M_MovementLineByMovementIdDataLoader";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_M_MovementLine_BY_M_Movement_ID,
				DataLoader.newMappedDataLoader(getByMovementIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MMovementLine_BH>> getByMovementIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MMovementLine_BH::getM_Movement_ID,
				MMovementLine_BH.COLUMNNAME_M_Movement_ID, keys);
	}
}
