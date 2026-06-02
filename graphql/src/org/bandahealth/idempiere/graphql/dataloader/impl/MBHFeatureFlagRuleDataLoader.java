package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHFeatureFlagRule;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MBHFeatureFlagRuleDataLoader extends X_BH_Feature_FlagDataLoader {
	public static String DATALOADER_BH_Feature_Flag_Rule_BY_BH_Feature_Flag_ID =
			"DATALOADER_BH_Feature_Flag_Rule_BY_BH_Feature_Flag_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_BH_Feature_Flag_Rule_BY_BH_Feature_Flag_ID,
				DataLoader.newMappedDataLoader(getByFeatureFlagIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MBHFeatureFlagRule>> getByFeatureFlagIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MBHFeatureFlagRule::getBH_Feature_Flag_ID,
				MBHFeatureFlagRule.COLUMNNAME_BH_Feature_Flag_ID, keys);
	}
}
