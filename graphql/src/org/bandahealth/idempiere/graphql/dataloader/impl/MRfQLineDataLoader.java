package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MRfQLine;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MRfQLineDataLoader extends X_C_RfQLineDataLoader {
	public static String DATALOADER_C_RfQLine_BY_C_RfQ_ID = "DATALOADER_C_RfQLine_BY_C_RfQ_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_C_RfQLine_BY_C_RfQ_ID,
				DataLoader.newMappedDataLoader(getByRfQIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MRfQLine>> getByRfQIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MRfQLine::getC_RfQ_ID,
				MRfQLine.COLUMNNAME_C_RfQ_ID, keys);
	}
}
