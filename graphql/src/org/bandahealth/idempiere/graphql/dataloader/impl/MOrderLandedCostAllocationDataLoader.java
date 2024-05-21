package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MOrderLandedCostAllocation;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MOrderLandedCostAllocationDataLoader extends X_C_OrderLandedCostAllocationDataLoader {
	public static String DATALOADER_C_OrderLandedCostAllocation_BY_C_OrderLine_ID =
			"DATALOADER_C_OrderLandedCostAllocation_BY_C_OrderLine_ID";
	public static String DATALOADER_C_OrderLandedCostAllocation_BY_C_OrderLandedCost_ID =
			"DATALOADER_C_OrderLandedCostAllocation_BY_C_OrderLandedCost_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_C_OrderLandedCostAllocation_BY_C_OrderLine_ID,
				DataLoader.newMappedDataLoader(getByOrderLineIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
		registry.register(DATALOADER_C_OrderLandedCostAllocation_BY_C_OrderLandedCost_ID,
				DataLoader.newMappedDataLoader(getByOrderLandedCostIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MOrderLandedCostAllocation>> getByOrderLineIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MOrderLandedCostAllocation::getC_OrderLine_ID,
				MOrderLandedCostAllocation.COLUMNNAME_C_OrderLine_ID, keys);
	}

	private MappedBatchLoaderWithContext<String, List<MOrderLandedCostAllocation>> getByOrderLandedCostIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MOrderLandedCostAllocation::getC_OrderLandedCost_ID,
				MOrderLandedCostAllocation.COLUMNNAME_C_OrderLandedCost_ID, keys);
	}
}
