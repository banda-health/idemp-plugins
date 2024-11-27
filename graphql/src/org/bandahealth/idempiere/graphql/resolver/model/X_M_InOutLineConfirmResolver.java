package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_InOutConfirmDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_InOutLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_InventoryLineDataLoader;
import org.compiere.model.MInOutConfirm;
import org.compiere.model.MInOutLine;
import org.compiere.model.MInOutLineConfirm;
import org.compiere.model.MInventoryLine;
import org.compiere.model.MInvoiceLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_InOutLineConfirm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_InOutLineConfirmResolver extends POResolver<MInOutLineConfirm> implements GraphQLResolver<MInOutLineConfirm> {



	/**
	 * Get Invoice Line.
	 *
	 * @return Invoice Detail Line
	 */
	public CompletableFuture<MInvoiceLine> C_InvoiceLine(MInOutLineConfirm entity, DataFetchingEnvironment environment) {
		if (entity.getC_InvoiceLine_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MInvoiceLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_InvoiceLineDataLoader.DATALOADER_C_InvoiceLine_BY_ID);
		return dataLoader.load(entity.getC_InvoiceLine_ID());
	}


	/**
	 * Get Ship/Receipt Confirmation.
	 *
	 * @return Material Shipment or Receipt Confirmation
	 */
	public CompletableFuture<MInOutConfirm> M_InOutConfirm(MInOutLineConfirm entity, DataFetchingEnvironment environment) {
		if (entity.getM_InOutConfirm_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MInOutConfirm> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_InOutConfirmDataLoader.DATALOADER_M_InOutConfirm_BY_ID);
		return dataLoader.load(entity.getM_InOutConfirm_ID());
	}


	/**
	 * Get Shipment/Receipt Line.
	 *
	 * @return Line on Shipment or Receipt document
	 */
	public CompletableFuture<MInOutLine> M_InOutLine(MInOutLineConfirm entity, DataFetchingEnvironment environment) {
		if (entity.getM_InOutLine_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MInOutLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_InOutLineDataLoader.DATALOADER_M_InOutLine_BY_ID);
		return dataLoader.load(entity.getM_InOutLine_ID());
	}


	/**
	 * Get Phys.Inventory Line.
	 *
	 * @return Unique line in an Inventory document
	 */
	public CompletableFuture<MInventoryLine> M_InventoryLine(MInOutLineConfirm entity, DataFetchingEnvironment environment) {
		if (entity.getM_InventoryLine_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MInventoryLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_InventoryLineDataLoader.DATALOADER_M_InventoryLine_BY_ID);
		return dataLoader.load(entity.getM_InventoryLine_ID());
	}

	public Boolean Processed(MInOutLineConfirm entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

}
