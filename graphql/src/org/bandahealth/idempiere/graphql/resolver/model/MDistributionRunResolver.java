package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MDistributionRunLineDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MDistributionRun;
import org.compiere.model.MDistributionRunLine;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MDistributionRunResolver extends X_M_DistributionRunResolver {

	public CompletableFuture<List<MDistributionRunLine>> M_DistributionRunLines(MDistributionRun entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MDistributionRunLine>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MDistributionRunLineDataLoader.DATALOADER_M_DistributionRunLine_BY_M_DistributionRun_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getM_DistributionRun_ID()));
	}
}
