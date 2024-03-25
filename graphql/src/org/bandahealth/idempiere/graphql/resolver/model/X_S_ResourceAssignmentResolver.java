package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_S_ResourceDataLoader;
import org.compiere.model.MResource;
import org.compiere.model.MResourceAssignment;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for S_ResourceAssignment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_S_ResourceAssignmentResolver extends POResolver<MResourceAssignment> implements GraphQLResolver<MResourceAssignment> {


	public Boolean IsConfirmed(MResourceAssignment entity, DataFetchingEnvironment environment) {
		return entity.isConfirmed();
	}


	/**
	 * Get Resource.
	 *
	 * @return Resource
	 */
	public CompletableFuture<MResource> S_Resource(MResourceAssignment entity, DataFetchingEnvironment environment) {
		if (entity.getS_Resource_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MResource> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_S_ResourceDataLoader.DATALOADER_S_Resource_BY_ID);
		return dataLoader.load(entity.getS_Resource_ID());
	}

}
