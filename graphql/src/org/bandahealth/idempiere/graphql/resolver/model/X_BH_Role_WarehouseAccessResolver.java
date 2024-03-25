package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHRoleWarehouseAccess;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_RoleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Role_WarehouseAccessDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_WarehouseDataLoader;
import org.compiere.model.X_AD_Role;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_Role_WarehouseAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_Role_WarehouseAccessResolver extends POResolver<MBHRoleWarehouseAccess> implements GraphQLResolver<MBHRoleWarehouseAccess> {



	/**
	 * Get Role.
	 *
	 * @return Responsibility Role
	 */
	public CompletableFuture<X_AD_Role> AD_Role(MBHRoleWarehouseAccess entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Role_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_Role> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_RoleDataLoader.DATALOADER_AD_Role_BY_ID);
		return dataLoader.load(entity.getAD_Role_ID());
	}


	/**
	 * Get BH_Role_WarehouseAccess_ID.
	 *
	 * @return BH_Role_WarehouseAccess_ID
	 */
	public CompletableFuture<MBHRoleWarehouseAccess> BH_Role_WarehouseAccess(MBHRoleWarehouseAccess entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Role_WarehouseAccess_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBHRoleWarehouseAccess> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_Role_WarehouseAccessDataLoader.DATALOADER_BH_Role_WarehouseAccess_BY_ID);
		return dataLoader.load(entity.getBH_Role_WarehouseAccess_ID());
	}

	public Boolean IsReadOnly(MBHRoleWarehouseAccess entity, DataFetchingEnvironment environment) {
		return entity.isReadOnly();
	}


	/**
	 * Get Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	public CompletableFuture<MWarehouse_BH> M_Warehouse(MBHRoleWarehouseAccess entity, DataFetchingEnvironment environment) {
		if (entity.getM_Warehouse_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MWarehouse_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_WarehouseDataLoader.DATALOADER_M_Warehouse_BY_ID);
		return dataLoader.load(entity.getM_Warehouse_ID());
	}

}
