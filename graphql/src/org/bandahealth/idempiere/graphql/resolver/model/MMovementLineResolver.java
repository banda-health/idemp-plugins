package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MMovementLineMADataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MStorageOnHandDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MMovementLine;
import org.compiere.model.MMovementLineMA;
import org.compiere.model.MStorageOnHand;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MMovementLineResolver extends X_M_MovementLineResolver {

	public CompletableFuture<List<MMovementLineMA>> M_MovementLineMAList(MMovementLine entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MMovementLineMA>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MMovementLineMADataLoader.DATALOADER_M_MovementLineMA_BY_M_MovementLine_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getM_MovementLine_ID()));
	}

	public CompletableFuture<List<MStorageOnHand>> M_StorageOnHandList(MMovementLine entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MStorageOnHand>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MStorageOnHandDataLoader.DATALOADER_M_StorageOnHand_By_Product_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getM_Product_ID()));
	}
}
