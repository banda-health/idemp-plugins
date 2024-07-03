package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHBPGeneralPayerInfo;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFldVal;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MBHBPGeneralPayerInfoDataLoader extends X_BH_BP_General_Payer_InfoDataLoader {
	public static String BH_BP_General_Payer_Info_BY_BY_PAYER_Info_ID_DATA_LOADER =
			"BH_BP_General_Payer_Info_ByPayerInfoIdDataLoader";
	public static String BH_BP_General_Payer_Info_BY_BH_Payer_Info_Fld_ID_DATA_LOADER =
			"BH_BP_General_Payer_Info_BY_BH_Payer_Info_Fld_ID_DATA_LOADER";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(BH_BP_General_Payer_Info_BY_BY_PAYER_Info_ID_DATA_LOADER,
				DataLoader.newMappedDataLoader(getByPayerInfoIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
		registry.register(BH_BP_General_Payer_Info_BY_BH_Payer_Info_Fld_ID_DATA_LOADER,
				DataLoader.newMappedDataLoader(getByPayerInformationFieldIdBatchLoader(),
						getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MBHBPGeneralPayerInfo>> getByPayerInfoIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MBHBPGeneralPayerInfo::getBH_BP_Payer_Info_ID,
				MBHBPGeneralPayerInfo.COLUMNNAME_BH_BP_Payer_Info_ID, keys);
	}

	private MappedBatchLoaderWithContext<String, List<MBHBPGeneralPayerInfo>> getByPayerInformationFieldIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MBHBPGeneralPayerInfo::getBH_Payer_Info_Fld_ID,
				MBHBPGeneralPayerInfo.COLUMNNAME_BH_Payer_Info_Fld_ID, keys);
	}
}
