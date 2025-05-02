package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHWarehouseAccess;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.util.Env;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;

public class MBHWarehouseAccessDataLoader extends X_BH_Warehouse_AccessDataLoader {
	public static String DATALOADER_BH_Warehouse_Access_BY_AD_Role_ID = "DATALOADER_BH_Warehouse_Access_BY_AD_Role_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_BH_Warehouse_Access_BY_AD_Role_ID,
				DataLoader.newMappedDataLoader(getByRoleIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MBHWarehouseAccess>> getByRoleIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> CompletableFuture.supplyAsync(() -> {
			try {
				// If the user is currently the system client, we can get everything
				if (Env.getAD_Client_ID(batchLoaderEnvironment.getContext()) == 0) {
					Repository.setApplyAccessFilterNotNeeded();
				}
				return Repository.getGroupsByModelKeys(batchLoaderEnvironment.getContext(), getTableName(), null,
						MBHWarehouseAccess::getAD_Role_ID, MBHWarehouseAccess.COLUMNNAME_AD_Role_ID, keys);
			} finally {
				Repository.clearApplyAccessFilterNotNeeded();
			}
		});
	}
}
