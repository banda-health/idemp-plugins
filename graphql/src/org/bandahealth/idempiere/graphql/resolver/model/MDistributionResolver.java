package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MDistributionLineDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MDistribution;
import org.compiere.model.MDistributionLine;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MDistributionResolver extends X_GL_DistributionResolver {

	public CompletableFuture<List<MDistributionLine>> GL_DistributionLines(MDistribution entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MDistributionLine>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MDistributionLineDataLoader.DATALOADER_M_DistributionLine_BY_GL_Distribution_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getGL_Distribution_ID()));
	}
}
