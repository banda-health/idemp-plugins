package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MMovementLineConfirm;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MMovementLineConfirmDataLoader extends X_M_MovementLineConfirmDataLoader {
	public static String DATALOADER_M_MovementLineConfirm_BY_M_MovementConfirm_ID = "DATALOADER_M_MovementLineConfirm_BY_M_MovementConfirm_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_M_MovementLineConfirm_BY_M_MovementConfirm_ID,
				DataLoader.newMappedDataLoader(getByMovementConfirmIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MMovementLineConfirm>> getByMovementConfirmIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MMovementLineConfirm::getM_MovementConfirm_ID,
				MMovementLineConfirm.COLUMNNAME_M_MovementConfirm_ID, keys);
	}
}
