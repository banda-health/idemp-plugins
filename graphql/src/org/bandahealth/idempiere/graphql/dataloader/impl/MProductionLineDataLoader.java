package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MProductionLine;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MProductionLineDataLoader extends X_M_ProductionLineDataLoader {
	public static String DATALOADER_M_ProductionLine_BY_M_ProductionPlan_ID =
			"DATALOADER_M_ProductionLine_BY_M_ProductionPlan_ID";
	public static String DATALOADER_M_ProductionLine_BY_M_Production_ID =
			"DATALOADER_M_ProductionLine_BY_M_Production_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_M_ProductionLine_BY_M_ProductionPlan_ID,
				DataLoader.newMappedDataLoader(getByProductionPlanIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
		registry.register(DATALOADER_M_ProductionLine_BY_M_Production_ID,
				DataLoader.newMappedDataLoader(getByProductionIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MProductionLine>> getByProductionPlanIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MProductionLine::getM_ProductionPlan_ID,
				MProductionLine.COLUMNNAME_M_ProductionPlan_ID, keys);
	}

	private MappedBatchLoaderWithContext<String, List<MProductionLine>> getByProductionIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MProductionLine::getM_Production_ID,
				MProductionLine.COLUMNNAME_M_Production_ID, keys);
	}
}
