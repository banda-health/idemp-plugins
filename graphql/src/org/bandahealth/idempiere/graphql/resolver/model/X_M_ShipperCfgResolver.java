package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ShippingProcessorCfgDataLoader;
import org.compiere.model.X_M_ShipperCfg;
import org.compiere.model.X_M_ShippingProcessorCfg;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_ShipperCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_ShipperCfgResolver extends POResolver<X_M_ShipperCfg> implements GraphQLResolver<X_M_ShipperCfg> {


	public Boolean IsInternational(X_M_ShipperCfg entity, DataFetchingEnvironment environment) {
		return entity.isInternational();
	}

	public Boolean IsOnline(X_M_ShipperCfg entity, DataFetchingEnvironment environment) {
		return entity.isOnline();
	}

	public Boolean IsResidential(X_M_ShipperCfg entity, DataFetchingEnvironment environment) {
		return entity.isResidential();
	}

	public Boolean IsSaturdayDelivery(X_M_ShipperCfg entity, DataFetchingEnvironment environment) {
		return entity.isSaturdayDelivery();
	}


	/**
	 * Get Shipping Processor Configuration.
	 *
	 * @return Shipping Processor Configuration
	 */
	public CompletableFuture<X_M_ShippingProcessorCfg> M_ShippingProcessorCfg(X_M_ShipperCfg entity, DataFetchingEnvironment environment) {
		if (entity.getM_ShippingProcessorCfg_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_M_ShippingProcessorCfg> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ShippingProcessorCfgDataLoader.DATALOADER_M_ShippingProcessorCfg_BY_ID);
		return dataLoader.load(entity.getM_ShippingProcessorCfg_ID());
	}

}
