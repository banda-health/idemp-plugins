package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MDunningRunLine;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MDunningRunLineDataLoader extends X_C_DunningRunLineDataLoader {
	public static String DATALOADER_C_DunningRunLine_BY_C_DunningRunEntry_ID =
			"DATALOADER_C_DunningRunLine_BY_C_DunningRunEntry_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_C_DunningRunLine_BY_C_DunningRunEntry_ID,
				DataLoader.newMappedDataLoader(getByDunningRunEntryIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MDunningRunLine>> getByDunningRunEntryIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MDunningRunLine::getC_DunningRunEntry_ID,
				MDunningRunLine.COLUMNNAME_C_DunningRunEntry_ID, keys);
	}
}
