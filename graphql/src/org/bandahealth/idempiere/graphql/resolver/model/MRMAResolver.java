package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MRMALineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MRMATaxDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MRMA;
import org.compiere.model.MRMALine;
import org.compiere.model.MRMATax;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MRMAResolver extends X_M_RMAResolver {

	public CompletableFuture<List<MRMALine>> M_RMALines(MRMA entity, DataFetchingEnvironment environment) {
		DataLoader<String, List<MRMALine>> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MRMALineDataLoader.DATALOADER_M_RMALine_BY_M_RMA_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getM_RMA_ID()));
	}

	public CompletableFuture<List<MRMATax>> M_RMATaxes(MRMA entity, DataFetchingEnvironment environment) {
		DataLoader<String, List<MRMATax>> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MRMATaxDataLoader.DATALOADER_M_RMATax_BY_M_RMA_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getM_RMA_ID()));
	}
}
