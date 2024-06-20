package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHBPPayerInfo;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MBHBPPayerInfoDataLoader extends X_BH_BP_Payer_InfoDataLoader {
	public static String BH_BP_Payer_Info_BY_BH_Payer_ID_DATA_LOADER = "BH_BP_Payer_Info_BY_BH_Payer_ID_DATA_LOADER";
	public static String BH_BP_Payer_Info_BY_C_BPartner_ID_DATA_LOADER = "BH_BP_Payer_Info_BY_C_BPartner_ID_DATA_LOADER";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(BH_BP_Payer_Info_BY_BH_Payer_ID_DATA_LOADER,
				DataLoader.newMappedDataLoader(getByPayerIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
		registry.register(BH_BP_Payer_Info_BY_C_BPartner_ID_DATA_LOADER,
				DataLoader.newMappedDataLoader(getByBusinessPartnerIdBatchLoader(),
						getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MBHBPPayerInfo>> getByPayerIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MBHBPPayerInfo::getBH_Payer_ID,
				MBHBPPayerInfo.COLUMNNAME_BH_Payer_ID, keys);
	}

	private MappedBatchLoaderWithContext<String, List<MBHBPPayerInfo>> getByBusinessPartnerIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MBHBPPayerInfo::getC_BPartner_ID,
				MBHBPPayerInfo.COLUMNNAME_C_BPartner_ID, keys);
	}
}
