package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHBPGeneralPayerInfo;
import org.bandahealth.idempiere.base.model.MBHBPPayerInfo;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHBPGeneralPayerInfoDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MBHBPPayerInfoResolver extends X_BH_BP_Payer_InfoResolver {
	public CompletableFuture<List<MBHBPGeneralPayerInfo>> BH_BP_General_Payer_InfoList(MBHBPPayerInfo entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHBPGeneralPayerInfo>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHBPGeneralPayerInfoDataLoader.BH_BP_General_Payer_Info_BY_BY_PAYER_Info_ID_DATA_LOADER);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getBH_BP_Payer_Info_ID()));
	}
}
