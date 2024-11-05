package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_RevenueRecognition_PlanDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.compiere.model.MRevenueRecognitionPlan;
import org.compiere.model.X_C_ServiceLevel;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_ServiceLevel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_ServiceLevelResolver extends POResolver<X_C_ServiceLevel> implements GraphQLResolver<X_C_ServiceLevel> {



	/**
	 * Get Revenue Recognition Plan.
	 *
	 * @return Plan for recognizing or recording revenue
	 */
	public CompletableFuture<MRevenueRecognitionPlan> C_RevenueRecognition_Plan(X_C_ServiceLevel entity, DataFetchingEnvironment environment) {
		if (entity.getC_RevenueRecognition_Plan_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MRevenueRecognitionPlan> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_RevenueRecognition_PlanDataLoader.DATALOADER_C_RevenueRecognition_Plan_BY_ID);
		return dataLoader.load(entity.getC_RevenueRecognition_Plan_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(X_C_ServiceLevel entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}

	public Boolean Processed(X_C_ServiceLevel entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(X_C_ServiceLevel entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
