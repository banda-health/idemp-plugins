package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MRfQResponseLine;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MRfQResponseLineDataLoader extends X_C_RfQResponseLineDataLoader {
	public static String DATALOADER_C_RfQResponseLine_BY_C_RfQResponse_ID =
			"DATALOADER_C_RfQResponseLine_BY_C_RfQResponse_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_C_RfQResponseLine_BY_C_RfQResponse_ID,
				DataLoader.newMappedDataLoader(getByRfQResponseIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MRfQResponseLine>> getByRfQResponseIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MRfQResponseLine::getC_RfQResponse_ID,
				MRfQResponseLine.COLUMNNAME_C_RfQResponse_ID, keys);
	}
}
