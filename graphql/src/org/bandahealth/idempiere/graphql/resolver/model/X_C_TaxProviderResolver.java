package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxProviderCfgDataLoader;
import org.compiere.model.MTaxProvider;
import org.compiere.model.X_C_TaxProviderCfg;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_TaxProvider - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_TaxProviderResolver extends POResolver<MTaxProvider> implements GraphQLResolver<MTaxProvider> {



	/**
	 * Get Tax Provider Configuration.
	 *
	 * @return Tax Provider Configuration
	 */
	public CompletableFuture<X_C_TaxProviderCfg> C_TaxProviderCfg(MTaxProvider entity, DataFetchingEnvironment environment) {
		if (entity.getC_TaxProviderCfg_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_C_TaxProviderCfg> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_TaxProviderCfgDataLoader.DATALOADER_C_TaxProviderCfg_BY_ID);
		return dataLoader.load(entity.getC_TaxProviderCfg_ID());
	}

}
