package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MDistributionRunLine;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MDistributionRunLineDataLoader extends X_M_DistributionRunLineDataLoader {
	public static String DATALOADER_M_DistributionRunLine_BY_M_DistributionRun_ID = "DATALOADER_M_DistributionRunLine_BY_M_DistributionRun_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_M_DistributionRunLine_BY_M_DistributionRun_ID,
				DataLoader.newMappedDataLoader(getByDistributionRunIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MDistributionRunLine>> getByDistributionRunIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MDistributionRunLine::getM_DistributionRun_ID,
				MDistributionRunLine.COLUMNNAME_M_DistributionRun_ID, keys);
	}
}
