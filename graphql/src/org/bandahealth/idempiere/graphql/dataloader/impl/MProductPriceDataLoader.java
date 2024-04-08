package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MProductPrice_BH;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MProductPriceDataLoader extends X_M_ProductPriceDataLoader {
	public static String DATALOADER_M_ProductPrice_BY_M_PriceList_Version_ID =
			"DATALOADER_M_ProductPrice_BY_M_PriceList_Version_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_M_ProductPrice_BY_M_PriceList_Version_ID,
				DataLoader.newMappedDataLoader(getByPriceListVersionIdBatchLoader(),
						getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MProductPrice_BH>> getByPriceListVersionIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MProductPrice_BH::getM_PriceList_Version_ID,
				MProductPrice_BH.COLUMNNAME_M_PriceList_Version_ID, keys);
	}
}
