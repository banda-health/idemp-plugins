package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MProjectTypePhaseDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MProjectType;
import org.compiere.model.MProjectTypePhase;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MProjectTypeResolver extends X_C_ProjectTypeResolver {

	public CompletableFuture<List<MProjectTypePhase>> C_Phases(MProjectType entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MProjectTypePhase>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MProjectTypePhaseDataLoader.DATALOADER_C_Phase_BY_C_ProjectType_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_ProjectType_ID()));
	}
}
