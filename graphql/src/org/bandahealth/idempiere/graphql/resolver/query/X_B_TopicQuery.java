package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_B_TopicDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_B_Topic;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for B_Topic - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_B_TopicQuery extends POQuery<X_B_Topic> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_B_Topic.Table_Name;
	}

	public CompletableFuture<X_B_Topic> B_Topic(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_B_Topic> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_B_TopicDataLoader.DATALOADER_B_Topic_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_B_Topic> B_TopicGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
