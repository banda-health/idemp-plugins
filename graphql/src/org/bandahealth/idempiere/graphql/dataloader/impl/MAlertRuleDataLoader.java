package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MAlertRule;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MAlertRuleDataLoader extends X_AD_AlertRuleDataLoader {
	public static String DATALOADER_AD_AlertRule_BY_AD_Alert_ID = "DATALOADER_AD_AlertRule_BY_AD_Alert_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_AD_AlertRule_BY_AD_Alert_ID,
				DataLoader.newMappedDataLoader(getByAlertIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MAlertRule>> getByAlertIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MAlertRule::getAD_Alert_ID,
				MAlertRule.COLUMNNAME_AD_Alert_ID, keys);
	}
}
