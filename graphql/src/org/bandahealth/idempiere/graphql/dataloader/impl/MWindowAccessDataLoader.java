package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MWindowAccess_BH;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.util.Env;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;

public class MWindowAccessDataLoader extends X_AD_Window_AccessDataLoader {
	public static String DATALOADER_AD_Window_Access_BY_AD_Role_ID = "DATALOADER_AD_Window_Access_BY_AD_Role_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_AD_Window_Access_BY_AD_Role_ID,
				DataLoader.newMappedDataLoader(getByRoleIdBatchLoader(), getOptionsWithCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MWindowAccess_BH>> getByRoleIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> CompletableFuture.supplyAsync(() -> {
			try {
				// If the user is currently the system client, we can get everything
				if (Env.getAD_Client_ID(batchLoaderEnvironment.getContext()) == 0) {
					Repository.setApplyAccessFilterNotNeeded();
				}
				return Repository.getGroupsByModelKeys(batchLoaderEnvironment.getContext(), getTableName(), null,
						MWindowAccess_BH::getAD_Role_ID, MWindowAccess_BH.COLUMNNAME_AD_Role_ID, keys);
			} finally {
				Repository.clearApplyAccessFilterNotNeeded();
			}
		});
	}
}
