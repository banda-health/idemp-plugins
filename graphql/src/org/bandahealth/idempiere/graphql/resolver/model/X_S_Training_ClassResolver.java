package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_S_TrainingDataLoader;
import org.compiere.model.X_S_Training;
import org.compiere.model.X_S_Training_Class;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for S_Training_Class - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_S_Training_ClassResolver extends POResolver<X_S_Training_Class> implements GraphQLResolver<X_S_Training_Class> {



	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(X_S_Training_Class entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}


	/**
	 * Get Training.
	 *
	 * @return Repeated Training
	 */
	public CompletableFuture<X_S_Training> S_Training(X_S_Training_Class entity, DataFetchingEnvironment environment) {
		if (entity.getS_Training_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_S_Training> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_S_TrainingDataLoader.DATALOADER_S_Training_BY_ID);
		return dataLoader.load(entity.getS_Training_ID());
	}

}
