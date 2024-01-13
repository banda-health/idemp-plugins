package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHBPSpecificPayerInfo;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MBHBPSpecificPayerInfoDataLoader extends X_BH_BP_Specific_Payer_InfoDataLoader {
	public static String BH_BP_Specific_Payer_Info_BY_InvoiceLine_ID_DATA_LOADER =
			"BH_BP_Specific_Payer_Info_ByInvoiceLineIdDataLoader";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(BH_BP_Specific_Payer_Info_BY_InvoiceLine_ID_DATA_LOADER,
				DataLoader.newMappedDataLoader(getByInvoiceLineIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MBHBPSpecificPayerInfo>> getByInvoiceLineIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MBHBPSpecificPayerInfo::getC_InvoiceLine_ID,
				MBHBPSpecificPayerInfo.COLUMNNAME_C_InvoiceLine_ID, keys);
	}
}
