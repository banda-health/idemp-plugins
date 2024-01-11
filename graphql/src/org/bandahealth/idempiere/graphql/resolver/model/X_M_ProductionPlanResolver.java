package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_LocatorDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductionDataLoader;
import org.compiere.model.MLocator;
import org.compiere.model.MProduction;
import org.compiere.model.MProductionPlan;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_ProductionPlan - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ProductionPlanResolver extends POResolver<MProductionPlan> implements GraphQLResolver<MProductionPlan> {



	/**
	 * Get Locator.
	 *
	 * @return Warehouse Locator
	 */
	public CompletableFuture<MLocator> M_Locator(MProductionPlan entity, DataFetchingEnvironment environment) {
		if (entity.getM_Locator_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MLocator> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_LocatorDataLoader.M_Locator_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Locator_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(MProductionPlan entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.M_Product_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Product_ID());
	}


	/**
	 * Get Production.
	 *
	 * @return Plan for producing a product
	 */
	public CompletableFuture<MProduction> M_Production(MProductionPlan entity, DataFetchingEnvironment environment) {
		if (entity.getM_Production_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProduction> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductionDataLoader.M_Production_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Production_ID());
	}

	public Boolean Processed(MProductionPlan entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

}
