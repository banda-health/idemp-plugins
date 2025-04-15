package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OrderSourceDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_OrderSource;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_OrderSource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_OrderSourceQuery extends POQuery<X_C_OrderSource> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_OrderSource.Table_Name;
	}

	public CompletableFuture<X_C_OrderSource> C_OrderSource(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_C_OrderSource> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_OrderSourceDataLoader.DATALOADER_C_OrderSource_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_C_OrderSource> C_OrderSourceGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
