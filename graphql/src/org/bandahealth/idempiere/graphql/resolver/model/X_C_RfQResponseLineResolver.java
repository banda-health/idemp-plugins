package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_RfQLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_RfQResponseDataLoader;
import org.compiere.model.MRfQLine;
import org.compiere.model.MRfQResponse;
import org.compiere.model.MRfQResponseLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_RfQResponseLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_RfQResponseLineResolver extends POResolver<MRfQResponseLine> implements GraphQLResolver<MRfQResponseLine> {



	/**
	 * Get RfQ Line.
	 *
	 * @return Request for Quotation Line
	 */
	public CompletableFuture<MRfQLine> C_RfQLine(MRfQResponseLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_RfQLine_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MRfQLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_RfQLineDataLoader.DATALOADER_C_RfQLine_BY_ID);
		return dataLoader.load(entity.getC_RfQLine_ID());
	}


	/**
	 * Get RfQ Response.
	 *
	 * @return Request for Quotation Response from a potential Vendor
	 */
	public CompletableFuture<MRfQResponse> C_RfQResponse(MRfQResponseLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_RfQResponse_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MRfQResponse> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_RfQResponseDataLoader.DATALOADER_C_RfQResponse_BY_ID);
		return dataLoader.load(entity.getC_RfQResponse_ID());
	}

	public Boolean IsSelectedWinner(MRfQResponseLine entity, DataFetchingEnvironment environment) {
		return entity.isSelectedWinner();
	}

	public Boolean IsSelfService(MRfQResponseLine entity, DataFetchingEnvironment environment) {
		return entity.isSelfService();
	}

}
