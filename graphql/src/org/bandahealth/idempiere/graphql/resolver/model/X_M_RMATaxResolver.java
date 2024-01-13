package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxProviderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_RMADataLoader;
import org.compiere.model.MRMA;
import org.compiere.model.MRMATax;
import org.compiere.model.MTax;
import org.compiere.model.MTaxProvider;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_RMATax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_RMATaxResolver extends POResolver<MRMATax> implements GraphQLResolver<MRMATax> {



	/**
	 * Get Tax.
	 *
	 * @return Tax identifier
	 */
	public CompletableFuture<MTax> C_Tax(MRMATax entity, DataFetchingEnvironment environment) {
		if (entity.getC_Tax_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTax> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_TaxDataLoader.DATALOADER_C_Tax_BY_ID);
		return dataLoader.load(entity.getC_Tax_ID());
	}


	/**
	 * Get Tax Provider.
	 *
	 * @return Tax Provider
	 */
	public CompletableFuture<MTaxProvider> C_TaxProvider(MRMATax entity, DataFetchingEnvironment environment) {
		if (entity.getC_TaxProvider_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTaxProvider> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_TaxProviderDataLoader.DATALOADER_C_TaxProvider_BY_ID);
		return dataLoader.load(entity.getC_TaxProvider_ID());
	}

	public Boolean IsTaxIncluded(MRMATax entity, DataFetchingEnvironment environment) {
		return entity.isTaxIncluded();
	}


	/**
	 * Get RMA.
	 *
	 * @return Return Material Authorization
	 */
	public CompletableFuture<MRMA> M_RMA(MRMATax entity, DataFetchingEnvironment environment) {
		if (entity.getM_RMA_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MRMA> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_RMADataLoader.DATALOADER_M_RMA_BY_ID);
		return dataLoader.load(entity.getM_RMA_ID());
	}

	public Boolean Processed(MRMATax entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

}
