package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ShipperDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ShipperPackagingCfgDataLoader;
import org.compiere.model.MShipper;
import org.compiere.model.MShipperPackaging;
import org.compiere.model.X_M_ShipperPackagingCfg;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_ShipperPackaging - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_ShipperPackagingResolver extends POResolver<MShipperPackaging> implements GraphQLResolver<MShipperPackaging> {


	public Boolean IsDefault(MShipperPackaging entity, DataFetchingEnvironment environment) {
		return entity.isDefault();
	}


	/**
	 * Get Shipper.
	 *
	 * @return Method or manner of product delivery
	 */
	public CompletableFuture<MShipper> M_Shipper(MShipperPackaging entity, DataFetchingEnvironment environment) {
		if (entity.getM_Shipper_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MShipper> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ShipperDataLoader.DATALOADER_M_Shipper_BY_ID);
		return dataLoader.load(entity.getM_Shipper_ID());
	}


	/**
	 * Get Shipper Packaging Configuration.
	 *
	 * @return Shipper Packaging Configuration
	 */
	public CompletableFuture<X_M_ShipperPackagingCfg> M_ShipperPackagingCfg(MShipperPackaging entity, DataFetchingEnvironment environment) {
		if (entity.getM_ShipperPackagingCfg_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_M_ShipperPackagingCfg> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ShipperPackagingCfgDataLoader.DATALOADER_M_ShipperPackagingCfg_BY_ID);
		return dataLoader.load(entity.getM_ShipperPackagingCfg_ID());
	}

}
