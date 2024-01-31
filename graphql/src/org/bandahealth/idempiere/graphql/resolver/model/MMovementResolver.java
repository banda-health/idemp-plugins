package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MMovementLine_BH;
import org.bandahealth.idempiere.base.model.MMovement_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.MMovementLineDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MMovementResolver extends X_M_MovementResolver {

	public CompletableFuture<List<MMovementLine_BH>> M_MovementLines(MMovement_BH entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MMovementLine_BH>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MMovementLineDataLoader.DATALOADER_M_MovementLine_BY_M_Movement_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.get_ID()));
	}
}
