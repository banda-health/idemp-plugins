package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_InventoryLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_MovementConfirmDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_MovementLineDataLoader;
import org.compiere.model.MInventoryLine;
import org.compiere.model.MMovementConfirm;
import org.compiere.model.MMovementLine;
import org.compiere.model.MMovementLineConfirm;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_MovementLineConfirm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_MovementLineConfirmResolver extends POResolver<MMovementLineConfirm> implements GraphQLResolver<MMovementLineConfirm> {



	/**
	 * Get Phys.Inventory Line.
	 *
	 * @return Unique line in an Inventory document
	 */
	public CompletableFuture<MInventoryLine> M_InventoryLine(MMovementLineConfirm entity, DataFetchingEnvironment environment) {
		if (entity.getM_InventoryLine_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MInventoryLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_InventoryLineDataLoader.DATALOADER_M_InventoryLine_BY_ID);
		return dataLoader.load(entity.getM_InventoryLine_ID());
	}


	/**
	 * Get Move Confirm.
	 *
	 * @return Inventory Move Confirmation
	 */
	public CompletableFuture<MMovementConfirm> M_MovementConfirm(MMovementLineConfirm entity, DataFetchingEnvironment environment) {
		if (entity.getM_MovementConfirm_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MMovementConfirm> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_MovementConfirmDataLoader.DATALOADER_M_MovementConfirm_BY_ID);
		return dataLoader.load(entity.getM_MovementConfirm_ID());
	}


	/**
	 * Get Move Line.
	 *
	 * @return Inventory Move document Line
	 */
	public CompletableFuture<MMovementLine> M_MovementLine(MMovementLineConfirm entity, DataFetchingEnvironment environment) {
		if (entity.getM_MovementLine_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MMovementLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_MovementLineDataLoader.DATALOADER_M_MovementLine_BY_ID);
		return dataLoader.load(entity.getM_MovementLine_ID());
	}

	public Boolean Processed(MMovementLineConfirm entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

}
