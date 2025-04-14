package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PInstanceDataLoader;
import org.compiere.model.MPInstance;
import org.dataloader.DataLoader;
import org.eevolution.model.X_T_MRP_CRP;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for T_MRP_CRP - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_T_MRP_CRPResolver extends POResolver<X_T_MRP_CRP> implements GraphQLResolver<X_T_MRP_CRP> {



	/**
	 * Get Process Instance.
	 *
	 * @return Instance of the process
	 */
	public CompletableFuture<MPInstance> AD_PInstance(X_T_MRP_CRP entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PInstance_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MPInstance> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PInstanceDataLoader.DATALOADER_AD_PInstance_BY_ID);
		return dataLoader.load(entity.getAD_PInstance_ID());
	}

}
