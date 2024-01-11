package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ServiceLevelDataLoader;
import org.compiere.model.X_C_ServiceLevel;
import org.compiere.model.X_C_ServiceLevelLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_ServiceLevelLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ServiceLevelLineResolver extends POResolver<X_C_ServiceLevelLine> implements GraphQLResolver<X_C_ServiceLevelLine> {



	/**
	 * Get Service Level.
	 *
	 * @return Product Revenue Recognition Service Level 
	 */
	public CompletableFuture<X_C_ServiceLevel> C_ServiceLevel(X_C_ServiceLevelLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_ServiceLevel_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_C_ServiceLevel> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ServiceLevelDataLoader.C_ServiceLevel_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_ServiceLevel_ID());
	}

	public Boolean Processed(X_C_ServiceLevelLine entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

}
