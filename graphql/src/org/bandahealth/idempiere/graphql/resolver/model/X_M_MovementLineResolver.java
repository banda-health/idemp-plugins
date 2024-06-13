package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MMovement_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_DD_OrderLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_AttributeSetInstanceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_LocatorDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_MovementDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_MovementLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.compiere.model.MLocator;
import org.compiere.model.MMovementLine;
import org.dataloader.DataLoader;
import org.eevolution.model.MDDOrderLine;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_MovementLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_MovementLineResolver extends POResolver<MMovementLine> implements GraphQLResolver<MMovementLine> {



	/**
	 * Get Distribution Order Line.
	 *
	 * @return Distribution Order Line
	 */
	public CompletableFuture<MDDOrderLine> DD_OrderLine(MMovementLine entity, DataFetchingEnvironment environment) {
		if (entity.getDD_OrderLine_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MDDOrderLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_DD_OrderLineDataLoader.DATALOADER_DD_OrderLine_BY_ID);
		return dataLoader.load(entity.getDD_OrderLine_ID());
	}


	/**
	 * Get Attribute Set Instance.
	 *
	 * @return Product Attribute Set Instance
	 */
	public CompletableFuture<MAttributeSetInstance_BH> M_AttributeSetInstance(MMovementLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_AttributeSetInstance_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MAttributeSetInstance_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_AttributeSetInstanceDataLoader.DATALOADER_M_AttributeSetInstance_BY_ID);
		return dataLoader.load(entity.getM_AttributeSetInstance_ID());
	}


	/**
	 * Get Attribute Set Instance To.
	 *
	 * @return Target Product Attribute Set Instance
	 */
	public CompletableFuture<MAttributeSetInstance_BH> M_AttributeSetInstanceTo(MMovementLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_AttributeSetInstanceTo_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MAttributeSetInstance_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_AttributeSetInstanceDataLoader.DATALOADER_M_AttributeSetInstance_BY_ID);
		return dataLoader.load(entity.getM_AttributeSetInstanceTo_ID());
	}


	/**
	 * Get Locator.
	 *
	 * @return Warehouse Locator
	 */
	public CompletableFuture<MLocator> M_Locator(MMovementLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_Locator_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MLocator> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_LocatorDataLoader.DATALOADER_M_Locator_BY_ID);
		return dataLoader.load(entity.getM_Locator_ID());
	}


	/**
	 * Get Locator To.
	 *
	 * @return Location inventory is moved to
	 */
	public CompletableFuture<MLocator> M_LocatorTo(MMovementLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_LocatorTo_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MLocator> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_LocatorDataLoader.DATALOADER_M_Locator_BY_ID);
		return dataLoader.load(entity.getM_LocatorTo_ID());
	}


	/**
	 * Get Inventory Move.
	 *
	 * @return Movement of Inventory
	 */
	public CompletableFuture<MMovement_BH> M_Movement(MMovementLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_Movement_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MMovement_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_MovementDataLoader.DATALOADER_M_Movement_BY_ID);
		return dataLoader.load(entity.getM_Movement_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(MMovementLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}

	public Boolean Processed(MMovementLine entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}


	/**
	 * Get Reversal Line.
	 *
	 * @return Use to keep the reversal line ID for reversing costing purpose
	 */
	public CompletableFuture<MMovementLine> ReversalLine(MMovementLine entity, DataFetchingEnvironment environment) {
		if (entity.getReversalLine_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MMovementLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_MovementLineDataLoader.DATALOADER_M_MovementLine_BY_ID);
		return dataLoader.load(entity.getReversalLine_ID());
	}

}
