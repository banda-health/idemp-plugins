package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_S_ResourceDataLoader;
import org.compiere.model.MResource;
import org.compiere.model.MResourceUnAvailable;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for S_ResourceUnAvailable - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_S_ResourceUnAvailableResolver extends POResolver<MResourceUnAvailable> implements GraphQLResolver<MResourceUnAvailable> {



	/**
	 * Get Resource.
	 *
	 * @return Resource
	 */
	public CompletableFuture<MResource> S_Resource(MResourceUnAvailable entity, DataFetchingEnvironment environment) {
		if (entity.getS_Resource_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MResource> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_S_ResourceDataLoader.DATALOADER_S_Resource_BY_ID);
		return dataLoader.load(entity.getS_Resource_ID());
	}

}
