package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MTab;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MTabDataLoader extends X_AD_TabDataLoader {
	public static String DATALOADER_AD_Tab_BY_AD_Window_ID = "AD_TabByWindowIdDataLoader";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_AD_Tab_BY_AD_Window_ID,
				DataLoader.newMappedDataLoader(getByWindowIdBatchLoader(), getOptionsWithCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MTab>> getByWindowIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MTab::getAD_Window_ID,
				MTab.COLUMNNAME_AD_Window_ID, keys);
	}
}
