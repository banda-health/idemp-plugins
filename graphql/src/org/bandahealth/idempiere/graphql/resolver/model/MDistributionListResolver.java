package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MDistributionListLineDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MDistributionList;
import org.compiere.model.MDistributionListLine;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MDistributionListResolver extends X_M_DistributionListResolver {

	public CompletableFuture<List<MDistributionListLine>> M_DistributionListLines(MDistributionList entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MDistributionListLine>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MDistributionListLineDataLoader.DATALOADER_M_DistributionListLine_BY_M_DistributionList_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getM_DistributionList_ID()));
	}
}
