package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OrderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxProviderDataLoader;
import org.compiere.model.MOrderTax;
import org.compiere.model.MTax;
import org.compiere.model.MTaxProvider;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_OrderTax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_OrderTaxResolver extends POResolver<MOrderTax> implements GraphQLResolver<MOrderTax> {



	/**
	 * Get Order.
	 *
	 * @return Order
	 */
	public CompletableFuture<MOrder_BH> C_Order(MOrderTax entity, DataFetchingEnvironment environment) {
		if (entity.getC_Order_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MOrder_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_OrderDataLoader.C_Order_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Order_ID());
	}


	/**
	 * Get Tax.
	 *
	 * @return Tax identifier
	 */
	public CompletableFuture<MTax> C_Tax(MOrderTax entity, DataFetchingEnvironment environment) {
		if (entity.getC_Tax_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTax> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_TaxDataLoader.C_Tax_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Tax_ID());
	}


	/**
	 * Get Tax Provider.
	 *
	 * @return Tax Provider
	 */
	public CompletableFuture<MTaxProvider> C_TaxProvider(MOrderTax entity, DataFetchingEnvironment environment) {
		if (entity.getC_TaxProvider_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTaxProvider> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_TaxProviderDataLoader.C_TaxProvider_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_TaxProvider_ID());
	}

	public Boolean IsTaxIncluded(MOrderTax entity, DataFetchingEnvironment environment) {
		return entity.isTaxIncluded();
	}

	public Boolean Processed(MOrderTax entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

}
