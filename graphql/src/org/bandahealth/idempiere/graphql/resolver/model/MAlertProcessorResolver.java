package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MAlertProcessorLogDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAlertProcessor;
import org.compiere.model.MAlertProcessorLog;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MAlertProcessorResolver extends X_AD_AlertProcessorResolver {

	public CompletableFuture<List<MAlertProcessorLog>> AD_AlertProcessorLogs(MAlertProcessor entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MAlertProcessorLog>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MAlertProcessorLogDataLoader.DATALOADER_AD_AlertProcessorLog_BY_AD_AlertProcessor_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getAD_AlertProcessor_ID()));
	}
}
