package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MDunningRunEntry;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MDunningRunEntryDataLoader extends X_C_DunningRunEntryDataLoader {
	public static String DATALOADER_C_DunningRunEntry_BY_C_DunningRun_ID = "DATALOADER_C_DunningRunEntry_BY_C_DunningRun_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_C_DunningRunEntry_BY_C_DunningRun_ID,
				DataLoader.newMappedDataLoader(getByDunningRunIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MDunningRunEntry>> getByDunningRunIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MDunningRunEntry::getC_DunningRun_ID,
				MDunningRunEntry.COLUMNNAME_C_DunningRun_ID, keys);
	}
}
