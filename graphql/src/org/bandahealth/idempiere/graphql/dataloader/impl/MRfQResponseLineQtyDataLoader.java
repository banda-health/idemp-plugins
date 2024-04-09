package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MRfQResponseLineQty;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MRfQResponseLineQtyDataLoader extends X_C_RfQResponseLineQtyDataLoader {
	public static String DATALOADER_C_RfQResponseLineQty_BY_C_RfQLineQty_ID =
			"DATALOADER_C_RfQResponseLineQty_BY_C_RfQLineQty_ID";
	public static String DATALOADER_C_RfQResponseLineQty_BY_C_RfQResponseLine_ID =
			"DATALOADER_C_RfQResponseLineQty_BY_C_RfQResponseLine_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_C_RfQResponseLineQty_BY_C_RfQLineQty_ID,
				DataLoader.newMappedDataLoader(getByRfQLineQtyIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
		registry.register(DATALOADER_C_RfQResponseLineQty_BY_C_RfQResponseLine_ID,
				DataLoader.newMappedDataLoader(getByRfQResponseLineIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MRfQResponseLineQty>> getByRfQLineQtyIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MRfQResponseLineQty::getC_RfQLineQty_ID,
				MRfQResponseLineQty.COLUMNNAME_C_RfQLineQty_ID, keys);
	}

	private MappedBatchLoaderWithContext<String, List<MRfQResponseLineQty>> getByRfQResponseLineIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MRfQResponseLineQty::getC_RfQResponseLine_ID,
				MRfQResponseLineQty.COLUMNNAME_C_RfQResponseLine_ID, keys);
	}
}
