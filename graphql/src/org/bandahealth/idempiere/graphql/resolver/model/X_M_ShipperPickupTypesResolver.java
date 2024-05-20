package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ShipperDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ShipperPickupTypesCfgDataLoader;
import org.compiere.model.MShipper;
import org.compiere.model.MShipperPickupTypes;
import org.compiere.model.X_M_ShipperPickupTypesCfg;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_ShipperPickupTypes - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_ShipperPickupTypesResolver extends POResolver<MShipperPickupTypes> implements GraphQLResolver<MShipperPickupTypes> {


	public Boolean IsDefault(MShipperPickupTypes entity, DataFetchingEnvironment environment) {
		return entity.isDefault();
	}


	/**
	 * Get Shipper.
	 *
	 * @return Method or manner of product delivery
	 */
	public CompletableFuture<MShipper> M_Shipper(MShipperPickupTypes entity, DataFetchingEnvironment environment) {
		if (entity.getM_Shipper_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MShipper> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ShipperDataLoader.DATALOADER_M_Shipper_BY_ID);
		return dataLoader.load(entity.getM_Shipper_ID());
	}


	/**
	 * Get Shipper Pickup Types Configuration.
	 *
	 * @return Shipper Pickup Types Configuration
	 */
	public CompletableFuture<X_M_ShipperPickupTypesCfg> M_ShipperPickupTypesCfg(MShipperPickupTypes entity, DataFetchingEnvironment environment) {
		if (entity.getM_ShipperPickupTypesCfg_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_M_ShipperPickupTypesCfg> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ShipperPickupTypesCfgDataLoader.DATALOADER_M_ShipperPickupTypesCfg_BY_ID);
		return dataLoader.load(entity.getM_ShipperPickupTypesCfg_ID());
	}

}
