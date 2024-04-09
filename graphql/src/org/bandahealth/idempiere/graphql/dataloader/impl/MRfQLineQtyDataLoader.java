package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MRfQLineQty;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MRfQLineQtyDataLoader extends X_C_RfQLineQtyDataLoader {
	public static String DATALOADER_C_RfQLineQty_BY_C_RfQLine_ID = "DATALOADER_C_RfQLineQty_BY_C_RfQLine_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_C_RfQLineQty_BY_C_RfQLine_ID,
				DataLoader.newMappedDataLoader(getByRfQLineIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MRfQLineQty>> getByRfQLineIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MRfQLineQty::getC_RfQLine_ID,
				MRfQLineQty.COLUMNNAME_C_RfQLine_ID, keys);
	}
}
