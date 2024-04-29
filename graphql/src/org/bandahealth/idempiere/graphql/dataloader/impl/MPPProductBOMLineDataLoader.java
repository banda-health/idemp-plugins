package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;
import org.eevolution.model.MPPProductBOMLine;

import java.util.List;
import java.util.Properties;

public class MPPProductBOMLineDataLoader extends X_PP_Product_BOMLineDataLoader {
	public static String DATALOADER_PP_Product_BOMLine_BY_PP_Product_BOM_ID =
			"DATALOADER_PP_Product_BOMLine_BY_PP_Product_BOM_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_PP_Product_BOMLine_BY_PP_Product_BOM_ID,
				DataLoader.newMappedDataLoader(getByPPProductBomIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MPPProductBOMLine>> getByPPProductBomIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MPPProductBOMLine::getPP_Product_BOM_ID,
				MPPProductBOMLine.COLUMNNAME_PP_Product_BOM_ID, keys);
	}
}
