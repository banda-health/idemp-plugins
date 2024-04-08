package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MPriceListVersionDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MPriceList;
import org.compiere.model.MPriceListVersion;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

public class MPriceListResolver extends X_M_PriceListResolver {

	public CompletableFuture<MPriceListVersion> M_PriceList_Version_Current(MPriceList entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, MPriceListVersion> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MPriceListVersionDataLoader.DATALOADER_M_PriceList_Version_BY_M_PriceList_AND_Today_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getM_PriceList_ID()));
	}
}
