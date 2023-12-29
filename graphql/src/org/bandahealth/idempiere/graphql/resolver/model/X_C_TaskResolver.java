package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PhaseDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.compiere.model.MProjectTypePhase;
import org.compiere.model.MProjectTypeTask;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for C_Task - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_TaskResolver extends POResolver<MProjectTypeTask> implements GraphQLResolver<MProjectTypeTask> {



	/**
	 * Get Standard Phase.
	 *
	 * @return Standard Phase of the Project Type
	 */
	public CompletableFuture<MProjectTypePhase> C_Phase(MProjectTypeTask entity, DataFetchingEnvironment environment) {
		if (entity.getC_Phase_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProjectTypePhase> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PhaseDataLoader.C_Phase_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Phase_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(MProjectTypeTask entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.M_Product_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Product_ID());
	}

}
