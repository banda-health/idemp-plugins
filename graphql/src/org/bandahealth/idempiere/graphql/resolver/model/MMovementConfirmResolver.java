package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MMovementLineConfirmDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MMovementConfirm;
import org.compiere.model.MMovementLineConfirm;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MMovementConfirmResolver extends X_M_MovementConfirmResolver {

	public CompletableFuture<List<MMovementLineConfirm>> M_MovementLineConfirmList(MMovementConfirm entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MMovementLineConfirm>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MMovementLineConfirmDataLoader.DATALOADER_M_MovementLineConfirm_BY_M_MovementConfirm_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getM_MovementConfirm_ID()));
	}
}
