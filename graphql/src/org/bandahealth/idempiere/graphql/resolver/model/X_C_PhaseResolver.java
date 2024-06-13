package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.compiere.model.MProjectType;
import org.compiere.model.MProjectTypePhase;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_Phase - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_PhaseResolver extends POResolver<MProjectTypePhase> implements GraphQLResolver<MProjectTypePhase> {



	/**
	 * Get Project Type.
	 *
	 * @return Type of the project
	 */
	public CompletableFuture<MProjectType> C_ProjectType(MProjectTypePhase entity, DataFetchingEnvironment environment) {
		if (entity.getC_ProjectType_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MProjectType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ProjectTypeDataLoader.DATALOADER_C_ProjectType_BY_ID);
		return dataLoader.load(entity.getC_ProjectType_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(MProjectTypePhase entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}

}
