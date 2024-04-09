package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MViewColumn;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MViewColumnDataLoader extends X_AD_ViewColumnDataLoader {
	public static String DATALOADER_AD_ViewColumn_BY_AD_ViewComponent_ID =
			"DATALOADER_AD_ViewColumn_BY_AD_ViewComponent_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_AD_ViewColumn_BY_AD_ViewComponent_ID,
				DataLoader.newMappedDataLoader(getByViewComponentIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MViewColumn>> getByViewComponentIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MViewColumn::getAD_ViewComponent_ID,
				MViewColumn.COLUMNNAME_AD_ViewComponent_ID, keys);
	}
}
