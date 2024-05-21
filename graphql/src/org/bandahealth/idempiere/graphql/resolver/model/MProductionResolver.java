package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MProductionLineDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MProduction;
import org.compiere.model.MProductionLine;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MProductionResolver extends X_M_ProductionResolver {

	public CompletableFuture<List<MProductionLine>> M_ProductionLines(MProduction entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MProductionLine>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MProductionLineDataLoader.DATALOADER_M_ProductionLine_BY_M_Production_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getM_Production_ID()));
	}
}
