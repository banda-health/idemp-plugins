package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_RfQLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_UOMDataLoader;
import org.compiere.model.MRfQLine;
import org.compiere.model.MRfQLineQty;
import org.compiere.model.MUOM;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_RfQLineQty - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_RfQLineQtyResolver extends POResolver<MRfQLineQty> implements GraphQLResolver<MRfQLineQty> {



	/**
	 * Get RfQ Line.
	 *
	 * @return Request for Quotation Line
	 */
	public CompletableFuture<MRfQLine> C_RfQLine(MRfQLineQty entity, DataFetchingEnvironment environment) {
		if (entity.getC_RfQLine_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MRfQLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_RfQLineDataLoader.DATALOADER_C_RfQLine_BY_ID);
		return dataLoader.load(entity.getC_RfQLine_ID());
	}


	/**
	 * Get UOM.
	 *
	 * @return Unit of Measure
	 */
	public CompletableFuture<MUOM> C_UOM(MRfQLineQty entity, DataFetchingEnvironment environment) {
		if (entity.getC_UOM_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUOM> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_UOMDataLoader.DATALOADER_C_UOM_BY_ID);
		return dataLoader.load(entity.getC_UOM_ID());
	}

	public Boolean IsOfferQty(MRfQLineQty entity, DataFetchingEnvironment environment) {
		return entity.isOfferQty();
	}

	public Boolean IsPurchaseQty(MRfQLineQty entity, DataFetchingEnvironment environment) {
		return entity.isPurchaseQty();
	}

	public Boolean IsRfQQty(MRfQLineQty entity, DataFetchingEnvironment environment) {
		return entity.isRfQQty();
	}

}
