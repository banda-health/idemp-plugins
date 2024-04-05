package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MCashPlanLine;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MCashPlanLineDataLoader extends X_C_CashPlanLineDataLoader {
	public static String DATALOADER_C_CashPlanLine_BY_C_CashPlan_ID = "DATALOADER_C_CashPlanLine_BY_C_CashPlan_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_C_CashPlanLine_BY_C_CashPlan_ID,
				DataLoader.newMappedDataLoader(getByCashPlanIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MCashPlanLine>> getByCashPlanIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MCashPlanLine::getC_CashPlan_ID,
				MCashPlanLine.COLUMNNAME_C_CashPlan_ID, keys);
	}
}
