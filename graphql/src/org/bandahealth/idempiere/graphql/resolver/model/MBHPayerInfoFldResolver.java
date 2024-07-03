package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHBPGeneralPayerInfo;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFld;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFldVal;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHBPGeneralPayerInfoDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHPayerInfoFldValDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MBHPayerInfoFldResolver extends X_BH_Payer_Info_FldResolver {
	public CompletableFuture<List<MBHPayerInfoFldVal>> BH_Payer_Info_Fld_ValList(MBHPayerInfoFld entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHPayerInfoFldVal>> dataLoader = environment.getDataLoaderRegistry().getDataLoader(
				MBHPayerInfoFldValDataLoader.BH_Payer_Info_Fld_Val_BY_BH_PAYER_INFO_FLD_ID_DATA_LOADER);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getBH_Payer_Info_Fld_ID()));
	}

	public CompletableFuture<List<MBHBPGeneralPayerInfo>> BH_BP_General_Payer_InfoList(MBHPayerInfoFld entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHBPGeneralPayerInfo>> dataLoader = environment.getDataLoaderRegistry().getDataLoader(
				MBHBPGeneralPayerInfoDataLoader.BH_BP_General_Payer_Info_BY_BH_Payer_Info_Fld_ID_DATA_LOADER);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getBH_Payer_Info_Fld_ID()));
	}
}
