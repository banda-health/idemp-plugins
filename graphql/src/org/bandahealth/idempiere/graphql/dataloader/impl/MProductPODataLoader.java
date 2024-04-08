package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MProductPO_BH;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MProductPODataLoader extends X_M_Product_PODataLoader {
	public static String DATALOADER_M_Product_PO_BY_M_Product_ID = "DATALOADER_M_Product_PO_BY_M_Product_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_M_Product_PO_BY_M_Product_ID,
				DataLoader.newMappedDataLoader(getByProductIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MProductPO_BH>> getByProductIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MProductPO_BH::getM_Product_ID,
				MProductPO_BH.COLUMNNAME_M_Product_ID, keys);
	}
}
