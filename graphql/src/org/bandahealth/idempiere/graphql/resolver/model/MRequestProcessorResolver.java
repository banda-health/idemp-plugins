package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MRequestProcessorLogDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MRequestProcessorRouteDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MRequestProcessor;
import org.compiere.model.MRequestProcessorLog;
import org.compiere.model.MRequestProcessorRoute;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MRequestProcessorResolver extends X_R_RequestProcessorResolver {

	public CompletableFuture<List<MRequestProcessorRoute>> R_RequestProcessor_Routes(MRequestProcessor entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MRequestProcessorRoute>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MRequestProcessorRouteDataLoader.DATALOADER_R_RequestProcessor_Route_BY_R_RequestProcessor_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getR_RequestProcessor_ID()));
	}

	public CompletableFuture<List<MRequestProcessorLog>> R_RequestProcessorLogs(MRequestProcessor entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MRequestProcessorLog>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MRequestProcessorLogDataLoader.DATALOADER_R_RequestProcessorLog_BY_R_RequestProcessor_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getR_RequestProcessor_ID()));
	}
}
