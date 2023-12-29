package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ShipperCfgDataLoader;
import org.compiere.model.X_M_ShipperCfg;
import org.compiere.model.X_M_ShipperPackagingCfg;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_ShipperPackagingCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ShipperPackagingCfgResolver extends POResolver<X_M_ShipperPackagingCfg> implements GraphQLResolver<X_M_ShipperPackagingCfg> {



	/**
	 * Get Shipper Configuration.
	 *
	 * @return Shipper Configuration
	 */
	public CompletableFuture<X_M_ShipperCfg> M_ShipperCfg(X_M_ShipperPackagingCfg entity, DataFetchingEnvironment environment) {
		if (entity.getM_ShipperCfg_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_M_ShipperCfg> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ShipperCfgDataLoader.M_ShipperCfg_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_ShipperCfg_ID());
	}

}
