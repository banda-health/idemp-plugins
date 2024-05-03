package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MDistributionListLine;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MDistributionListLineDataLoader extends X_M_DistributionListLineDataLoader {
	public static String DATALOADER_M_DistributionListLine_BY_M_DistributionList_ID =
			"DATALOADER_M_DistributionListLine_BY_M_DistributionList_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_M_DistributionListLine_BY_M_DistributionList_ID,
				DataLoader.newMappedDataLoader(getByDistributionLineIdBatchLoader(),
						getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MDistributionListLine>> getByDistributionLineIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MDistributionListLine::getM_DistributionList_ID,
				MDistributionListLine.COLUMNNAME_M_DistributionList_ID, keys);
	}
}
