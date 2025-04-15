package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_B_TopicTypeDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_B_TopicType;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for B_TopicType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_B_TopicTypeQuery extends POQuery<X_B_TopicType> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_B_TopicType.Table_Name;
	}

	public CompletableFuture<X_B_TopicType> B_TopicType(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_B_TopicType> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_B_TopicTypeDataLoader.DATALOADER_B_TopicType_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_B_TopicType> B_TopicTypeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
