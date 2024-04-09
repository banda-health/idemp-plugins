package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MRfQLineDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MRfQ;
import org.compiere.model.MRfQLine;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MRfQResolver extends X_C_RfQResolver {

	public CompletableFuture<List<MRfQLine>> C_RfQLines(MRfQ entity, DataFetchingEnvironment environment) {
		DataLoader<String, List<MRfQLine>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MRfQLineDataLoader.DATALOADER_C_RfQLine_BY_C_RfQ_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_RfQ_ID()));
	}
}
