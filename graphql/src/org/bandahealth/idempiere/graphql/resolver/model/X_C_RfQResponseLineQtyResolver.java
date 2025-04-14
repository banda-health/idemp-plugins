package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_RfQLineQtyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_RfQResponseLineDataLoader;
import org.compiere.model.MRfQLineQty;
import org.compiere.model.MRfQResponseLine;
import org.compiere.model.MRfQResponseLineQty;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_RfQResponseLineQty - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_RfQResponseLineQtyResolver extends POResolver<MRfQResponseLineQty> implements GraphQLResolver<MRfQResponseLineQty> {



	/**
	 * Get RfQ Line Quantity.
	 *
	 * @return Request for Quotation Line Quantity
	 */
	public CompletableFuture<MRfQLineQty> C_RfQLineQty(MRfQResponseLineQty entity, DataFetchingEnvironment environment) {
		if (entity.getC_RfQLineQty_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MRfQLineQty> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_RfQLineQtyDataLoader.DATALOADER_C_RfQLineQty_BY_ID);
		return dataLoader.load(entity.getC_RfQLineQty_ID());
	}


	/**
	 * Get RfQ Response Line.
	 *
	 * @return Request for Quotation Response Line
	 */
	public CompletableFuture<MRfQResponseLine> C_RfQResponseLine(MRfQResponseLineQty entity, DataFetchingEnvironment environment) {
		if (entity.getC_RfQResponseLine_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MRfQResponseLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_RfQResponseLineDataLoader.DATALOADER_C_RfQResponseLine_BY_ID);
		return dataLoader.load(entity.getC_RfQResponseLine_ID());
	}

}
