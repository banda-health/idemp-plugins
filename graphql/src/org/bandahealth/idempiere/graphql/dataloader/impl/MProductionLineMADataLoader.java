package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MProductionLineMA;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MProductionLineMADataLoader extends X_M_ProductionLineMADataLoader {
	public static String DATALOADER_M_ProductionLineMA_BY_M_ProductionLine_ID =
			"DATALOADER_M_ProductionLineMA_BY_M_ProductionLine_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_M_ProductionLineMA_BY_M_ProductionLine_ID,
				DataLoader.newMappedDataLoader(getByProductionLineIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MProductionLineMA>> getByProductionLineIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MProductionLineMA::getM_ProductionLine_ID,
				MProductionLineMA.COLUMNNAME_M_ProductionLine_ID, keys);
	}
}
