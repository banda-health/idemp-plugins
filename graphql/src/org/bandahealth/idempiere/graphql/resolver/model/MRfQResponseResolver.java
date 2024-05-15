package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MRfQResponseLineDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MRfQResponse;
import org.compiere.model.MRfQResponseLine;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MRfQResponseResolver extends X_C_RfQResponseResolver {

	public CompletableFuture<List<MRfQResponseLine>> C_RfQResponseLines(MRfQResponse entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MRfQResponseLine>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MRfQResponseLineDataLoader.DATALOADER_C_RfQResponseLine_BY_C_RfQResponse_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_RfQResponse_ID()));
	}
}
