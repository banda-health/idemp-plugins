package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MPPProductBOMLineDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.dataloader.DataLoader;
import org.eevolution.model.MPPProductBOM;
import org.eevolution.model.MPPProductBOMLine;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MPPProductBOMResolver extends X_PP_Product_BOMResolver {

	public CompletableFuture<List<MPPProductBOMLine>> PP_Product_BOMLines(MPPProductBOM entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MPPProductBOMLine>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MPPProductBOMLineDataLoader.DATALOADER_PP_Product_BOMLine_BY_PP_Product_BOM_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getPP_Product_BOM_ID()));
	}
}
