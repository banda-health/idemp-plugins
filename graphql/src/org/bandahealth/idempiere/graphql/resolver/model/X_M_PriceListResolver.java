package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PriceListDataLoader;
import org.compiere.model.MCurrency;
import org.compiere.model.MPriceList;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for M_PriceList - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_PriceListResolver extends POResolver<MPriceList> implements GraphQLResolver<MPriceList> {



	/**
	 * Get Base Pricelist.
	 *
	 * @return Pricelist to be used, if product not found on this pricelist
	 */
	public CompletableFuture<MPriceList> BasePriceList(MPriceList entity, DataFetchingEnvironment environment) {
		if (entity.getBasePriceList_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPriceList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_PriceListDataLoader.M_PriceList_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getBasePriceList_ID());
	}


	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public CompletableFuture<MCurrency> C_Currency(MPriceList entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCurrency> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.C_Currency_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Currency_ID());
	}

}
