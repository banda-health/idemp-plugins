package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_B_TopicCategoryDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_B_TopicTypeDataLoader;
import org.compiere.model.X_B_Topic;
import org.compiere.model.X_B_TopicCategory;
import org.compiere.model.X_B_TopicType;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for B_Topic - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_B_TopicResolver extends POResolver<X_B_Topic> implements GraphQLResolver<X_B_Topic> {



	/**
	 * Get Topic Category.
	 *
	 * @return Auction Topic Category
	 */
	public CompletableFuture<X_B_TopicCategory> B_TopicCategory(X_B_Topic entity, DataFetchingEnvironment environment) {
		if (entity.getB_TopicCategory_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_B_TopicCategory> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_B_TopicCategoryDataLoader.DATALOADER_B_TopicCategory_BY_ID);
		return dataLoader.load(entity.getB_TopicCategory_ID());
	}


	/**
	 * Get Topic Type.
	 *
	 * @return Auction Topic Type
	 */
	public CompletableFuture<X_B_TopicType> B_TopicType(X_B_Topic entity, DataFetchingEnvironment environment) {
		if (entity.getB_TopicType_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_B_TopicType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_B_TopicTypeDataLoader.DATALOADER_B_TopicType_BY_ID);
		return dataLoader.load(entity.getB_TopicType_ID());
	}

	public Boolean IsPublished(X_B_Topic entity, DataFetchingEnvironment environment) {
		return entity.isPublished();
	}

	public Boolean Processed(X_B_Topic entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(X_B_Topic entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
