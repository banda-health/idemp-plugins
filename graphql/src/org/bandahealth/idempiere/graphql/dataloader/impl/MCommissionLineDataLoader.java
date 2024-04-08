package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MCommissionLine;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MCommissionLineDataLoader extends X_C_CommissionLineDataLoader {
	public static String DATALOADER_C_CommissionLine_BY_C_Commission_ID =
			"DATALOADER_C_CommissionLine_BY_C_Commission_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_C_CommissionLine_BY_C_Commission_ID,
				DataLoader.newMappedDataLoader(getByCommissionIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MCommissionLine>> getByCommissionIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MCommissionLine::getC_Commission_ID,
				MCommissionLine.COLUMNNAME_C_Commission_ID, keys);
	}
}
