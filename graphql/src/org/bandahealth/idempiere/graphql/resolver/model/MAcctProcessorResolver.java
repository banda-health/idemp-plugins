package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MAcctProcessorLogDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAcctProcessor;
import org.compiere.model.MAcctProcessorLog;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MAcctProcessorResolver extends X_C_AcctProcessorResolver {

	public CompletableFuture<List<MAcctProcessorLog>> C_AcctProcessorLogs(MAcctProcessor entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MAcctProcessorLog>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MAcctProcessorLogDataLoader.DATALOADER_C_AcctProcessorLog_BY_C_AcctProcessor_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_AcctProcessor_ID()));
	}
}
