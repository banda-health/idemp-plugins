package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MDiscountSchemaBreak;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MDiscountSchemaBreakDataLoader extends X_M_DiscountSchemaBreakDataLoader {
	public static String DATALOADER_M_DiscountSchemaBreak_BY_M_DiscountSchema_ID =
			"DATALOADER_M_DiscountSchemaBreak_BY_M_DiscountSchema_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_M_DiscountSchemaBreak_BY_M_DiscountSchema_ID,
				DataLoader.newMappedDataLoader(getByDiscountSchemaIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MDiscountSchemaBreak>> getByDiscountSchemaIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MDiscountSchemaBreak::getM_DiscountSchema_ID,
				MDiscountSchemaBreak.COLUMNNAME_M_DiscountSchema_ID, keys);
	}
}
