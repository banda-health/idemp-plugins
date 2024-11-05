package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_LocatorTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_WarehouseDataLoader;
import org.compiere.model.MLocator;
import org.compiere.model.MLocatorType;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_Locator - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_LocatorResolver extends POResolver<MLocator> implements GraphQLResolver<MLocator> {


	public Boolean IsDefault(MLocator entity, DataFetchingEnvironment environment) {
		return entity.isDefault();
	}


	/**
	 * Get Locator Type.
	 *
	 * @return Locator Type
	 */
	public CompletableFuture<MLocatorType> M_LocatorType(MLocator entity, DataFetchingEnvironment environment) {
		if (entity.getM_LocatorType_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MLocatorType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_LocatorTypeDataLoader.DATALOADER_M_LocatorType_BY_ID);
		return dataLoader.load(entity.getM_LocatorType_ID());
	}


	/**
	 * Get Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	public CompletableFuture<MWarehouse_BH> M_Warehouse(MLocator entity, DataFetchingEnvironment environment) {
		if (entity.getM_Warehouse_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MWarehouse_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_WarehouseDataLoader.DATALOADER_M_Warehouse_BY_ID);
		return dataLoader.load(entity.getM_Warehouse_ID());
	}

}
