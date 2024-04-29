package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MIndexColumn;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MIndexColumnDataLoader extends X_AD_IndexColumnDataLoader {
	public static String DATALOADER_AD_IndexColumn_BY_AD_TableIndex_ID = "DATALOADER_AD_IndexColumn_BY_AD_TableIndex_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_AD_IndexColumn_BY_AD_TableIndex_ID,
				DataLoader.newMappedDataLoader(getByTableIndexIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MIndexColumn>> getByTableIndexIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MIndexColumn::getAD_TableIndex_ID,
				MIndexColumn.COLUMNNAME_AD_TableIndex_ID, keys);
	}
}
