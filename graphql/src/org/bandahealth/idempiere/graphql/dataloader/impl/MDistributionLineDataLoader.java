package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MDistributionLine;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MDistributionLineDataLoader extends X_GL_DistributionLineDataLoader {
	public static String DATALOADER_M_DistributionLine_BY_GL_Distribution_ID =
			"DATALOADER_M_DistributionLine_BY_GL_Distribution_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_M_DistributionLine_BY_GL_Distribution_ID,
				DataLoader.newMappedDataLoader(getByDistributionIdBatchLoader(),
						getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MDistributionLine>> getByDistributionIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MDistributionLine::getGL_Distribution_ID,
				MDistributionLine.COLUMNNAME_GL_Distribution_ID, keys);
	}
}
