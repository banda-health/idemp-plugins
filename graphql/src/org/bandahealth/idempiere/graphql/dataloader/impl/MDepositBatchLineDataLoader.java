package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MDepositBatchLine;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MDepositBatchLineDataLoader extends X_C_DepositBatchLineDataLoader {
	public static String DATALOADER_C_DepositBatchLine_BY_C_DepositBatch_ID = "DATALOADER_C_DepositBatchLine_BY_C_DepositBatch_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_C_DepositBatchLine_BY_C_DepositBatch_ID,
				DataLoader.newMappedDataLoader(getByDepositBatchIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MDepositBatchLine>> getByDepositBatchIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MDepositBatchLine::getC_DepositBatch_ID,
				MDepositBatchLine.COLUMNNAME_C_DepositBatch_ID, keys);
	}
}
