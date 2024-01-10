package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MOrg;
import org.compiere.util.Env;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;

public class MOrgDataLoader extends X_AD_OrgDataLoader {
	public static String AD_Org_BY_CLIENT_ID_DATA_LOADER = "AD_OrgByClientIdDataLoader";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(AD_Org_BY_CLIENT_ID_DATA_LOADER,
				DataLoader.newMappedDataLoader(getByClientIdBatchLoader(), getOptionsWithCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MOrg>> getByClientIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> CompletableFuture.supplyAsync(() -> {
			// If the user is currently the system client, we can get everything
			if (Env.getAD_Client_ID(batchLoaderEnvironment.getContext()) == 0) {
				Repository.setApplyAccessFilterNotNeeded();
			}
			Map<String, List<MOrg>> organizationsByModelKeys =
					Repository.getGroupsByModelKeys(batchLoaderEnvironment.getContext(), getTableName(), null,
							MOrg::getAD_Client_ID, MOrg.COLUMNNAME_AD_Client_ID, keys);
			Repository.clearApplyAccessFilterNotNeeded();
			return organizationsByModelKeys;
		});
	}
}
