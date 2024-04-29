package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MProjectTypeTaskDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MProjectTypePhase;
import org.compiere.model.MProjectTypeTask;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MProjectTypePhaseResolver extends X_C_PhaseResolver {

	public CompletableFuture<List<MProjectTypeTask>> C_Tasks(MProjectTypePhase entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MProjectTypeTask>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MProjectTypeTaskDataLoader.DATALOADER_C_Task_BY_C_Phase_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_Phase_ID()));
	}
}
