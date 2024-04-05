package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MChatEntry;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MChatEntryDataLoader extends X_CM_ChatEntryDataLoader {
	public static String DATALOADER_CM_ChatEntry_BY_CM_Chat_ID = "DATALOADER_CM_ChatEntry_BY_CM_Chat_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_CM_ChatEntry_BY_CM_Chat_ID,
				DataLoader.newMappedDataLoader(getByChatIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MChatEntry>> getByChatIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MChatEntry::getCM_Chat_ID,
				MChatEntry.COLUMNNAME_CM_Chat_ID, keys);
	}
}
