package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProductPrice_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.MProductPriceDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MPriceListVersion;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MPriceListVersionResolver extends X_M_PriceList_VersionResolver {

	public CompletableFuture<List<MProductPrice_BH>> M_ProductPriceList(MPriceListVersion entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MProductPrice_BH>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MProductPriceDataLoader.DATALOADER_M_ProductPrice_BY_M_PriceList_Version_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getM_PriceList_Version_ID()));
	}
}
