package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MProductionLineMADataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MProductionLine;
import org.compiere.model.MProductionLineMA;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MProductionLineResolver extends X_M_ProductionLineResolver {
	public String ProductType(MProductionLine entity) {
		return null;
	}

	public String QtyAvailable(MProductionLine entity) {
		return null;
	}

	public CompletableFuture<List<MProductionLineMA>> M_ProductionLineMAList(MProductionLine entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MProductionLineMA>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MProductionLineMADataLoader.DATALOADER_M_ProductionLineMA_BY_M_ProductionLine_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getM_ProductionLine_ID()));
	}
}
