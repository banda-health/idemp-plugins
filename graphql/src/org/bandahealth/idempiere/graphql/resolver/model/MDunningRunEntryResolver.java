package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MDunningRunLineDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MDunningRunEntry;
import org.compiere.model.MDunningRunLine;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MDunningRunEntryResolver extends X_C_DunningRunEntryResolver {

	public CompletableFuture<List<MDunningRunLine>> C_DunningRunLines(MDunningRunEntry entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MDunningRunLine>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MDunningRunLineDataLoader.DATALOADER_C_DunningRunLine_BY_C_DunningRunEntry_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_DunningRunEntry_ID()));
	}
}
