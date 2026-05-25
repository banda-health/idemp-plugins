package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHFeatureFlag;
import org.bandahealth.idempiere.base.model.MBHFeatureFlagRule;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHFeatureFlagRuleDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MBHFeatureFlagResolver extends X_BH_Feature_FlagResolver {

	public CompletableFuture<List<MBHFeatureFlagRule>> BH_Feature_Flag_Rules(MBHFeatureFlag entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHFeatureFlagRule>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHFeatureFlagRuleDataLoader.DATALOADER_BH_Feature_Flag_Rule_BY_BH_Feature_Flag_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.get_ID()));
	}
}
