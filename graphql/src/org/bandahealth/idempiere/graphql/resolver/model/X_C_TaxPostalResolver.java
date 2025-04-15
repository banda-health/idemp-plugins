package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxDataLoader;
import org.compiere.model.MTax;
import org.compiere.model.MTaxPostal;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_TaxPostal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_TaxPostalResolver extends POResolver<MTaxPostal> implements GraphQLResolver<MTaxPostal> {



	/**
	 * Get Tax.
	 *
	 * @return Tax identifier
	 */
	public CompletableFuture<MTax> C_Tax(MTaxPostal entity, DataFetchingEnvironment environment) {
		if (entity.getC_Tax_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MTax> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_TaxDataLoader.DATALOADER_C_Tax_BY_ID);
		return dataLoader.load(entity.getC_Tax_ID());
	}

}
