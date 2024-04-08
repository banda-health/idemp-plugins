package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MInOutLine;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MInOutLineDataLoader extends X_M_InOutLineDataLoader {
	public static String DATALOADER_M_InOutLine_BY_M_Product_ID = "DATALOADER_M_InOutLine_BY_M_Product_ID";
	public static String DATALOADER_M_InOutLine_BY_C_OrderLine_ID = "DATALOADER_M_InOutLine_BY_C_OrderLine_ID";
	public static String DATALOADER_M_InOutLine_BY_M_RMALine_ID = "DATALOADER_M_InOutLine_BY_M_RMALine_ID";
	public static String DATALOADER_M_InOutLine_BY_M_InOut_ID = "DATALOADER_M_InOutLine_BY_M_InOut_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_M_InOutLine_BY_M_Product_ID,
				DataLoader.newMappedDataLoader(getByProductIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
		registry.register(DATALOADER_M_InOutLine_BY_C_OrderLine_ID,
				DataLoader.newMappedDataLoader(getByOrderLineIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
		registry.register(DATALOADER_M_InOutLine_BY_M_RMALine_ID,
				DataLoader.newMappedDataLoader(getByRmaLineIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
		registry.register(DATALOADER_M_InOutLine_BY_M_InOut_ID,
				DataLoader.newMappedDataLoader(getByInOutIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MInOutLine>> getByProductIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MInOutLine::getM_Product_ID,
				MInOutLine.COLUMNNAME_M_Product_ID, keys);
	}

	private MappedBatchLoaderWithContext<String, List<MInOutLine>> getByOrderLineIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MInOutLine::getC_OrderLine_ID,
				MInOutLine.COLUMNNAME_C_OrderLine_ID, keys);
	}

	private MappedBatchLoaderWithContext<String, List<MInOutLine>> getByRmaLineIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MInOutLine::getM_RMALine_ID,
				MInOutLine.COLUMNNAME_M_RMALine_ID, keys);
	}

	private MappedBatchLoaderWithContext<String, List<MInOutLine>> getByInOutIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MInOutLine::getM_InOut_ID,
				MInOutLine.COLUMNNAME_M_InOut_ID, keys);
	}
}
