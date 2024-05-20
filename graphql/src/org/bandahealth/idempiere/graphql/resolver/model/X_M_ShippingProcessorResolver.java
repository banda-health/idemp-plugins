package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ShippingProcessorCfgDataLoader;
import org.compiere.model.MShippingProcessor;
import org.compiere.model.X_M_ShippingProcessorCfg;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_ShippingProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_ShippingProcessorResolver extends POResolver<MShippingProcessor> implements GraphQLResolver<MShippingProcessor> {



	/**
	 * Get Shipping Processor Configuration.
	 *
	 * @return Shipping Processor Configuration
	 */
	public CompletableFuture<X_M_ShippingProcessorCfg> M_ShippingProcessorCfg(MShippingProcessor entity, DataFetchingEnvironment environment) {
		if (entity.getM_ShippingProcessorCfg_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_M_ShippingProcessorCfg> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ShippingProcessorCfgDataLoader.DATALOADER_M_ShippingProcessorCfg_BY_ID);
		return dataLoader.load(entity.getM_ShippingProcessorCfg_ID());
	}

}
