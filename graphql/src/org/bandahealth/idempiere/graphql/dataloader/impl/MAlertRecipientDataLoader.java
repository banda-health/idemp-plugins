package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MAlertRecipient;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MAlertRecipientDataLoader extends X_AD_AlertRecipientDataLoader {
	public static String DATALOADER_AD_AlertRecipient_BY_AD_Alert_ID = "DATALOADER_AD_AlertRecipient_BY_AD_Alert_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_AD_AlertRecipient_BY_AD_Alert_ID,
				DataLoader.newMappedDataLoader(getByAlertIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MAlertRecipient>> getByAlertIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MAlertRecipient::getAD_Alert_ID,
				MAlertRecipient.COLUMNNAME_AD_Alert_ID, keys);
	}
}
