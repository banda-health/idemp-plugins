package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MViewComponent;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MViewComponentDataLoader extends X_AD_ViewComponentDataLoader {
	public static String DATALOADER_AD_ViewComponent_BY_AD_Table_ID = "DATALOADER_AD_ViewComponent_BY_AD_Table_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_AD_ViewComponent_BY_AD_Table_ID,
				DataLoader.newMappedDataLoader(getByTableIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MViewComponent>> getByTableIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MViewComponent::getAD_Table_ID,
				MViewComponent.COLUMNNAME_AD_Table_ID, keys);
	}
}
