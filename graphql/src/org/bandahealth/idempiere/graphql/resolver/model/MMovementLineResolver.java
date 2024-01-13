package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MMovementLine_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.MStorageOnHandDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MStorageOnHand;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MMovementLineResolver extends X_M_MovementLineResolver {
	public CompletableFuture<List<MStorageOnHand>> M_StorageOnHandList(MMovementLine_BH entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MStorageOnHand>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MStorageOnHandDataLoader.DATALOADER_M_StorageOnHand_By_Product_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getM_Product_ID()));
	}
}
