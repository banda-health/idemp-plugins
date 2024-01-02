package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PriceListDataLoader;
import org.compiere.model.MPriceList;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

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
	public CompletableFuture<MCurrency_BH> C_Currency(MPriceList entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCurrency_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.C_Currency_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Currency_ID());
	}

	public Boolean EnforcePriceLimit(MPriceList entity, DataFetchingEnvironment environment) {
		return entity.isEnforcePriceLimit();
	}

	public Boolean IsDefault(MPriceList entity, DataFetchingEnvironment environment) {
		return entity.isDefault();
	}

	public Boolean IsMandatory(MPriceList entity, DataFetchingEnvironment environment) {
		return entity.isMandatory();
	}

	public Boolean isPresentForProduct(MPriceList entity, DataFetchingEnvironment environment) {
		return entity.isPresentForProduct();
	}

	public Boolean IsSOPriceList(MPriceList entity, DataFetchingEnvironment environment) {
		return entity.isSOPriceList();
	}

	public Boolean IsTaxIncluded(MPriceList entity, DataFetchingEnvironment environment) {
		return entity.isTaxIncluded();
	}

}
