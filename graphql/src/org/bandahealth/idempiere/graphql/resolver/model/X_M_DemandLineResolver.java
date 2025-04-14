package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PeriodDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_DemandDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.compiere.model.MPeriod;
import org.compiere.model.X_M_Demand;
import org.compiere.model.X_M_DemandLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_DemandLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_DemandLineResolver extends POResolver<X_M_DemandLine> implements GraphQLResolver<X_M_DemandLine> {



	/**
	 * Get Period.
	 *
	 * @return Period of the Calendar
	 */
	public CompletableFuture<MPeriod> C_Period(X_M_DemandLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_Period_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MPeriod> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PeriodDataLoader.DATALOADER_C_Period_BY_ID);
		return dataLoader.load(entity.getC_Period_ID());
	}


	/**
	 * Get Demand.
	 *
	 * @return Material Demand
	 */
	public CompletableFuture<X_M_Demand> M_Demand(X_M_DemandLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_Demand_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_M_Demand> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_DemandDataLoader.DATALOADER_M_Demand_BY_ID);
		return dataLoader.load(entity.getM_Demand_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(X_M_DemandLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}

}
