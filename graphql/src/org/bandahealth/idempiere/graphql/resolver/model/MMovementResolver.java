package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MMovement_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.MMovementConfirmDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MMovementLineDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MMovementConfirm;
import org.compiere.model.MMovementLine;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MMovementResolver extends X_M_MovementResolver {

	public CompletableFuture<List<MMovementConfirm>> M_MovementConfirmList(MMovement_BH entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MMovementConfirm>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MMovementConfirmDataLoader.DATALOADER_M_MovementConfirm_BY_M_Movement_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.get_ID()));
	}

	public CompletableFuture<List<MMovementLine>> M_MovementLines(MMovement_BH entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MMovementLine>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MMovementLineDataLoader.DATALOADER_M_MovementLine_BY_M_Movement_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.get_ID()));
	}
}
