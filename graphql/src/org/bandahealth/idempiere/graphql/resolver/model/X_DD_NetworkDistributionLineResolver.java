package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_DD_NetworkDistributionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ShipperDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_WarehouseDataLoader;
import org.compiere.model.MShipper;
import org.dataloader.DataLoader;
import org.eevolution.model.X_DD_NetworkDistribution;
import org.eevolution.model.X_DD_NetworkDistributionLine;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for DD_NetworkDistributionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_DD_NetworkDistributionLineResolver extends POResolver<X_DD_NetworkDistributionLine> implements GraphQLResolver<X_DD_NetworkDistributionLine> {



	/**
	 * Get Network Distribution.
	 *
	 * @return Network Distribution
	 */
	public CompletableFuture<X_DD_NetworkDistribution> DD_NetworkDistribution(X_DD_NetworkDistributionLine entity, DataFetchingEnvironment environment) {
		if (entity.getDD_NetworkDistribution_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_DD_NetworkDistribution> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_DD_NetworkDistributionDataLoader.DATALOADER_DD_NetworkDistribution_BY_ID);
		return dataLoader.load(entity.getDD_NetworkDistribution_ID());
	}


	/**
	 * Get Shipper.
	 *
	 * @return Method or manner of product delivery
	 */
	public CompletableFuture<MShipper> M_Shipper(X_DD_NetworkDistributionLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_Shipper_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MShipper> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ShipperDataLoader.DATALOADER_M_Shipper_BY_ID);
		return dataLoader.load(entity.getM_Shipper_ID());
	}


	/**
	 * Get Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	public CompletableFuture<MWarehouse_BH> M_Warehouse(X_DD_NetworkDistributionLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_Warehouse_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MWarehouse_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_WarehouseDataLoader.DATALOADER_M_Warehouse_BY_ID);
		return dataLoader.load(entity.getM_Warehouse_ID());
	}


	/**
	 * Get Source Warehouse.
	 *
	 * @return Optional Warehouse to replenish from
	 */
	public CompletableFuture<MWarehouse_BH> M_WarehouseSource(X_DD_NetworkDistributionLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_WarehouseSource_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MWarehouse_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_WarehouseDataLoader.DATALOADER_M_Warehouse_BY_ID);
		return dataLoader.load(entity.getM_WarehouseSource_ID());
	}

}
