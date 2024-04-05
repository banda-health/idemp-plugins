package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MCommissionAmt;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MCommissionAmtDataLoader extends X_C_CommissionAmtDataLoader {
	public static String DATALOADER_C_CommissionAmt_BY_C_CommissionRun_ID =
			"DATALOADER_C_CommissionAmt_BY_C_CommissionRun_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_C_CommissionAmt_BY_C_CommissionRun_ID,
				DataLoader.newMappedDataLoader(getByCommissionRunIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MCommissionAmt>> getByCommissionRunIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MCommissionAmt::getC_CommissionRun_ID,
				MCommissionAmt.COLUMNNAME_C_CommissionRun_ID, keys);
	}
}
