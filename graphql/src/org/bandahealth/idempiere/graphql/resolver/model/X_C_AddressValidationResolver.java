package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AddressValidationCfgDataLoader;
import org.compiere.model.MAddressValidation;
import org.compiere.model.X_C_AddressValidationCfg;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_AddressValidation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_AddressValidationResolver extends POResolver<MAddressValidation> implements GraphQLResolver<MAddressValidation> {



	/**
	 * Get Address Validation Configuration.
	 *
	 * @return Address Validation Configuration
	 */
	public CompletableFuture<X_C_AddressValidationCfg> C_AddressValidationCfg(MAddressValidation entity, DataFetchingEnvironment environment) {
		if (entity.getC_AddressValidationCfg_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_C_AddressValidationCfg> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_AddressValidationCfgDataLoader.DATALOADER_C_AddressValidationCfg_BY_ID);
		return dataLoader.load(entity.getC_AddressValidationCfg_ID());
	}

}
