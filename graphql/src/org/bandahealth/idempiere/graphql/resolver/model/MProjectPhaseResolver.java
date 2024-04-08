package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MProjectLineDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MProjectLine;
import org.compiere.model.MProjectPhase;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MProjectPhaseResolver extends X_C_ProjectPhaseResolver {

	public CompletableFuture<List<MProjectLine>> C_ProjectLines(MProjectPhase entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MProjectLine>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MProjectLineDataLoader.DATALOADER_C_ProjectLine_BY_C_ProjectPhase_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_ProjectPhase_ID()));
	}
}
