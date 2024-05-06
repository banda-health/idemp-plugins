package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MTaxPostal;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MTaxPostalDataLoader extends X_C_TaxPostalDataLoader {
	public static String DATALOADER_C_TaxPostal_BY_C_Tax_ID = "DATALOADER_C_TaxPostal_BY_C_Tax_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_C_TaxPostal_BY_C_Tax_ID,
				DataLoader.newMappedDataLoader(getByTaxIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MTaxPostal>> getByTaxIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MTaxPostal::getC_Tax_ID,
				MTaxPostal.COLUMNNAME_C_TaxPostal_ID, keys);
	}
}
