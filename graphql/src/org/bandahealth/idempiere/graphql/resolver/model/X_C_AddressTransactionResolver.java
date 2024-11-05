package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AddressValidationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_LocationDataLoader;
import org.compiere.model.MAddressTransaction;
import org.compiere.model.MAddressValidation;
import org.compiere.model.MLocation;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_AddressTransaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_AddressTransactionResolver extends POResolver<MAddressTransaction> implements GraphQLResolver<MAddressTransaction> {



	/**
	 * Get Address Validation.
	 *
	 * @return Address Validation
	 */
	public CompletableFuture<MAddressValidation> C_AddressValidation(MAddressTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getC_AddressValidation_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MAddressValidation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_AddressValidationDataLoader.DATALOADER_C_AddressValidation_BY_ID);
		return dataLoader.load(entity.getC_AddressValidation_ID());
	}


	/**
	 * Get Address.
	 *
	 * @return Location or Address
	 */
	public CompletableFuture<MLocation> C_Location(MAddressTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getC_Location_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_LocationDataLoader.DATALOADER_C_Location_BY_ID);
		return dataLoader.load(entity.getC_Location_ID());
	}

	public Boolean IsValid(MAddressTransaction entity, DataFetchingEnvironment environment) {
		return entity.isValid();
	}

	public Boolean Processed(MAddressTransaction entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

}
