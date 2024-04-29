package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MChatEntryDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MChat;
import org.compiere.model.MChatEntry;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MChatResolver extends X_CM_ChatResolver {

	public CompletableFuture<List<MChatEntry>> CM_ChatEntryList(MChat entity, DataFetchingEnvironment environment) {
		DataLoader<String, List<MChatEntry>> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MChatEntryDataLoader.DATALOADER_CM_ChatEntry_BY_CM_Chat_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getCM_Chat_ID()));
	}
}
