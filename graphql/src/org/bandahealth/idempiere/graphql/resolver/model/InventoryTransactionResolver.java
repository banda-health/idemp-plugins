package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MMovement_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.MAttributeSetInstanceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHVisitDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MLocatorDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MMovementDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MOrderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MProductDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MTransactionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.model.InventoryTransaction;
import org.compiere.model.MLocator;
import org.compiere.model.MTransaction;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

public class InventoryTransactionResolver implements GraphQLResolver<InventoryTransaction> {

	/**
	 * Return the user entity for this object of who created this entity, leveraging the user data loader
	 *
	 * @param Entity      The entity to fetch data for
	 * @param environment The GraphQL environment object
	 * @return A completable future of the user who created the entity
	 */
	public CompletableFuture<MUser_BH> CreatedBy(InventoryTransaction Entity, DataFetchingEnvironment environment) {
		final DataLoader<Integer, MUser_BH> userDataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return userDataLoader.load(Entity.getCreatedBy());
	}

	public CompletableFuture<MTransaction> M_Transaction(InventoryTransaction Entity,
			DataFetchingEnvironment environment) {
		final DataLoader<Integer, MTransaction> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MTransactionDataLoader.DATALOADER_M_Transaction_BY_ID);
		return dataLoader.load(Entity.getTransactionId());
	}

	public CompletableFuture<MOrder_BH> C_Order(InventoryTransaction Entity, DataFetchingEnvironment environment) {
		final DataLoader<Integer, MOrder_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MOrderDataLoader.DATALOADER_C_Order_BY_ID);
		return dataLoader.load(Entity.getOrderId());
	}

	public CompletableFuture<MMovement_BH> M_Movement(InventoryTransaction Entity, DataFetchingEnvironment environment) {
		final DataLoader<Integer, MMovement_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MMovementDataLoader.DATALOADER_M_Movement_BY_ID);
		return dataLoader.load(Entity.getMovementId());
	}

	public CompletableFuture<MBHVisit> BH_Visit(InventoryTransaction Entity, DataFetchingEnvironment environment) {
		final DataLoader<Integer, MBHVisit> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MBHVisitDataLoader.DATALOADER_BH_Visit_BY_ID);
		return dataLoader.load(Entity.getVisitId());
	}

	public CompletableFuture<MLocator> M_Locator(InventoryTransaction Entity, DataFetchingEnvironment environment) {
		final DataLoader<Integer, MLocator> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MLocatorDataLoader.DATALOADER_M_Locator_BY_ID);
		return dataLoader.load(Entity.getLocatorId());
	}

	public CompletableFuture<MProduct_BH> M_Product(InventoryTransaction Entity, DataFetchingEnvironment environment) {
		final DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(Entity.getProductId());
	}

	public CompletableFuture<MAttributeSetInstance_BH> M_AttributeSetInstance(InventoryTransaction Entity,
			DataFetchingEnvironment environment) {
		final DataLoader<Integer, MAttributeSetInstance_BH> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MAttributeSetInstanceDataLoader.DATALOADER_M_AttributeSetInstance_BY_ID);
		return dataLoader.load(Entity.getAttributeSetInstanceId());
	}
}
