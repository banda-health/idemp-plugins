package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MMovementConfirm;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MMovementConfirmDataLoader extends X_M_MovementConfirmDataLoader {
	public static String DATALOADER_M_MovementConfirm_BY_M_Movement_ID = "DATALOADER_M_MovementConfirm_BY_M_Movement_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_M_MovementConfirm_BY_M_Movement_ID,
				DataLoader.newMappedDataLoader(getByMovementIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MMovementConfirm>> getByMovementIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MMovementConfirm::getM_Movement_ID,
				MMovementConfirm.COLUMNNAME_M_Movement_ID, keys);
	}
}
