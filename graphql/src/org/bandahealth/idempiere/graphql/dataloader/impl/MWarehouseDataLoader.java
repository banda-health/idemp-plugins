package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MWarehouse_BH;
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

public class MWarehouseDataLoader extends X_M_WarehouseDataLoader {
	public static String M_Warehouse_BY_ORGANIZATION_ID_DATA_LOADER = "M_WarehouseByOrganizationIdDataLoader";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(M_Warehouse_BY_ORGANIZATION_ID_DATA_LOADER,
				DataLoader.newMappedDataLoader(getByOrganizationKeyBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MWarehouse_BH>> getByOrganizationKeyBatchLoader() {
		return (keys, batchLoaderEnvironment) -> CompletableFuture.supplyAsync(() -> {
			// If the user is currently the system client, we can get everything
			if (Env.getAD_Client_ID(batchLoaderEnvironment.getContext()) == 0) {
				Repository.setApplyAccessFilterNotNeeded();
			}
			Map<String, List<MWarehouse_BH>> warehousesByModelKeys =
					Repository.getGroupsByModelKeys(batchLoaderEnvironment.getContext(), getTableName(), null,
							MWarehouse_BH::getAD_Org_ID, MWarehouse_BH.COLUMNNAME_AD_Org_ID, keys);
			Repository.clearApplyAccessFilterNotNeeded();
			return warehousesByModelKeys;
		});
	}
}
