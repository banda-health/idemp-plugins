package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MLdapProcessorLogDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MLdapProcessor;
import org.compiere.model.MLdapProcessorLog;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MLdapProcessorResolver extends X_AD_LdapProcessorResolver {

	public CompletableFuture<List<MLdapProcessorLog>> AD_LdapProcessorLogs(MLdapProcessor entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MLdapProcessorLog>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MLdapProcessorLogDataLoader.DATALOADER_AD_LdapProcessorLog_BY_AD_LdapProcessor_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getAD_LdapProcessor_ID()));
	}
}
