package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MCommissionDetail;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MCommissionDetailDataLoader extends X_C_CommissionDetailDataLoader {
	public static String DATALOADER_C_CommissionDetail_BY_C_CommissionAmt_ID =
			"DATALOADER_C_CommissionDetail_BY_C_CommissionAmt_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_C_CommissionDetail_BY_C_CommissionAmt_ID,
				DataLoader.newMappedDataLoader(getByCommissionAmtIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MCommissionDetail>> getByCommissionAmtIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MCommissionDetail::getC_CommissionAmt_ID,
				MCommissionDetail.COLUMNNAME_C_CommissionAmt_ID, keys);
	}
}
