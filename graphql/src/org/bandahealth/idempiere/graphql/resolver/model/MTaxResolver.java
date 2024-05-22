package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MTaxPostalDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MTax;
import org.compiere.model.MTaxPostal;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MTaxResolver extends X_C_TaxResolver {

	public CompletableFuture<List<MTaxPostal>> C_TaxPostalList(MTax entity, DataFetchingEnvironment environment) {
		DataLoader<String, List<MTaxPostal>> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MTaxPostalDataLoader.DATALOADER_C_TaxPostal_BY_C_Tax_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_Tax_ID()));
	}
}
