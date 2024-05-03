package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MProductionLineDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MProductionLine;
import org.compiere.model.MProductionPlan;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MProductionPlanResolver extends X_M_ProductionPlanResolver {

	public CompletableFuture<List<MProductionLine>> M_ProductionLines(MProductionPlan entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MProductionLine>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MProductionLineDataLoader.DATALOADER_M_ProductionLine_BY_M_ProductionPlan_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getM_ProductionPlan_ID()));
	}
}
