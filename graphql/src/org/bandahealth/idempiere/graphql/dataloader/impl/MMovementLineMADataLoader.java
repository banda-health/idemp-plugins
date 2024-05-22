package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MMovementLineMA;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MMovementLineMADataLoader extends X_M_MovementLineMADataLoader {
	public static String DATALOADER_M_MovementLineMA_BY_M_MovementLine_ID =
			"DATALOADER_M_MovementLineMA_BY_M_MovementLine_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_M_MovementLineMA_BY_M_MovementLine_ID,
				DataLoader.newMappedDataLoader(getByMovementLineIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MMovementLineMA>> getByMovementLineIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MMovementLineMA::getM_MovementLine_ID,
				MMovementLineMA.COLUMNNAME_M_MovementLine_ID, keys);
	}
}
