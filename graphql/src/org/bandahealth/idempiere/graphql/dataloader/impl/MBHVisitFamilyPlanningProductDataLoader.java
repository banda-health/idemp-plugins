package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHVisitFamilyPlanningProduct;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MBHVisitFamilyPlanningProductDataLoader extends X_BH_Visit_Family_Planning_ProductDataLoader {
	public static String DATALOADER_BH_Visit_Family_Planning_Product_BY_BH_Visit_Family_Planning_ID =
			"BH_VisitFamilyPlanningProductByFamilyPlanningIdDataLoader";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_BH_Visit_Family_Planning_Product_BY_BH_Visit_Family_Planning_ID,
				DataLoader.newMappedDataLoader(getByFamilyPlanningIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MBHVisitFamilyPlanningProduct>> getByFamilyPlanningIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null,
				MBHVisitFamilyPlanningProduct::getBH_Visit_Family_Planning_ID,
				MBHVisitFamilyPlanningProduct.COLUMNNAME_BH_Visit_Family_Planning_ID, keys);
	}
}
