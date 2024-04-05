package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MDunningRunEntryDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MDunningRun;
import org.compiere.model.MDunningRunEntry;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MDunningRunResolver extends X_C_DunningRunResolver {

	public CompletableFuture<List<MDunningRunEntry>> C_DunningRunLines(MDunningRun entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MDunningRunEntry>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MDunningRunEntryDataLoader.DATALOADER_C_DunningRunEntry_BY_C_DunningRun_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_DunningRun_ID()));
	}
}
