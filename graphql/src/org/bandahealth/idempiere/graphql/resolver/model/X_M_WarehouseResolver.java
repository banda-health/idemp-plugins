package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_LocationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_LocatorDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_WarehouseDataLoader;
import org.compiere.model.MLocation;
import org.compiere.model.MLocator;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_Warehouse - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_WarehouseResolver extends POResolver<MWarehouse_BH> implements GraphQLResolver<MWarehouse_BH> {


	public Boolean BH_DefaultWarehouse(MWarehouse_BH entity, DataFetchingEnvironment environment) {
		return entity.isBH_DefaultWarehouse();
	}


	/**
	 * Get Address.
	 *
	 * @return Location or Address
	 */
	public CompletableFuture<MLocation> C_Location(MWarehouse_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Location_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_LocationDataLoader.DATALOADER_C_Location_BY_ID);
		return dataLoader.load(entity.getC_Location_ID());
	}

	public Boolean IsDisallowNegativeInv(MWarehouse_BH entity, DataFetchingEnvironment environment) {
		return entity.isDisallowNegativeInv();
	}

	public Boolean IsInTransit(MWarehouse_BH entity, DataFetchingEnvironment environment) {
		return entity.isInTransit();
	}


	/**
	 * Get Reservation Locator.
	 *
	 * @return Reservation Locator (just for reporting purposes)
	 */
	public CompletableFuture<MLocator> M_ReserveLocator(MWarehouse_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_ReserveLocator_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MLocator> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_LocatorDataLoader.DATALOADER_M_Locator_BY_ID);
		return dataLoader.load(entity.getM_ReserveLocator_ID());
	}


	/**
	 * Get Source Warehouse.
	 *
	 * @return Optional Warehouse to replenish from
	 */
	public CompletableFuture<MWarehouse_BH> M_WarehouseSource(MWarehouse_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_WarehouseSource_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MWarehouse_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_WarehouseDataLoader.DATALOADER_M_Warehouse_BY_ID);
		return dataLoader.load(entity.getM_WarehouseSource_ID());
	}

}
