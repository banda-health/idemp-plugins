package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MCashPlanLineDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCashPlan;
import org.compiere.model.MCashPlanLine;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MCashPlanResolver extends X_C_CashPlanResolver {

	public CompletableFuture<List<MCashPlanLine>> C_CashPlanLines(MCashPlan entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MCashPlanLine>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MCashPlanLineDataLoader.DATALOADER_C_CashPlanLine_BY_C_CashPlan_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_CashPlan_ID()));
	}
}
