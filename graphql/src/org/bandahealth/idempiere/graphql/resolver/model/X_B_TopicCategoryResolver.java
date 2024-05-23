package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_B_TopicTypeDataLoader;
import org.compiere.model.X_B_TopicCategory;
import org.compiere.model.X_B_TopicType;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for B_TopicCategory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_B_TopicCategoryResolver extends POResolver<X_B_TopicCategory> implements GraphQLResolver<X_B_TopicCategory> {



	/**
	 * Get Topic Type.
	 *
	 * @return Auction Topic Type
	 */
	public CompletableFuture<X_B_TopicType> B_TopicType(X_B_TopicCategory entity, DataFetchingEnvironment environment) {
		if (entity.getB_TopicType_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_B_TopicType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_B_TopicTypeDataLoader.DATALOADER_B_TopicType_BY_ID);
		return dataLoader.load(entity.getB_TopicType_ID());
	}

}
