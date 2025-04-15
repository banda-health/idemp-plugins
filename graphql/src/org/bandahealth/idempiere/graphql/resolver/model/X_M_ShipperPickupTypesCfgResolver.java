package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ShipperCfgDataLoader;
import org.compiere.model.X_M_ShipperCfg;
import org.compiere.model.X_M_ShipperPickupTypesCfg;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_ShipperPickupTypesCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_ShipperPickupTypesCfgResolver extends POResolver<X_M_ShipperPickupTypesCfg> implements GraphQLResolver<X_M_ShipperPickupTypesCfg> {


	public Boolean IsDefault(X_M_ShipperPickupTypesCfg entity, DataFetchingEnvironment environment) {
		return entity.isDefault();
	}


	/**
	 * Get Shipper Configuration.
	 *
	 * @return Shipper Configuration
	 */
	public CompletableFuture<X_M_ShipperCfg> M_ShipperCfg(X_M_ShipperPickupTypesCfg entity, DataFetchingEnvironment environment) {
		if (entity.getM_ShipperCfg_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_M_ShipperCfg> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ShipperCfgDataLoader.DATALOADER_M_ShipperCfg_BY_ID);
		return dataLoader.load(entity.getM_ShipperCfg_ID());
	}

}
