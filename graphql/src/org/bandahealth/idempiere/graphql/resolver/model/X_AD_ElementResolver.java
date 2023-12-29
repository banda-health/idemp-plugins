package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_EntityTypeDataLoader;
import org.compiere.model.MEntityType;
import org.compiere.model.M_Element;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for AD_Element - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ElementResolver extends POResolver<M_Element> implements GraphQLResolver<M_Element> {



	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	public CompletableFuture<MEntityType> AD_EntityType(M_Element entity, DataFetchingEnvironment environment) {
		if (entity.getEntityType() <= 0) {
			return null;
		}
		DataLoader<Integer, MEntityType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_EntityTypeDataLoader.AD_EntityType_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getEntityType());
	}

}
