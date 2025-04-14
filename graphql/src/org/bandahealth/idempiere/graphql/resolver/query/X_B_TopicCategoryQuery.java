package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_B_TopicCategoryDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_B_TopicCategory;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for B_TopicCategory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_B_TopicCategoryQuery extends POQuery<X_B_TopicCategory> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_B_TopicCategory.Table_Name;
	}

	public CompletableFuture<X_B_TopicCategory> B_TopicCategory(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_B_TopicCategory> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_B_TopicCategoryDataLoader.DATALOADER_B_TopicCategory_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_B_TopicCategory> B_TopicCategoryGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
