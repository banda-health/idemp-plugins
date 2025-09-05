package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_S_ResourceUnAvailableDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MResourceUnAvailable;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for S_ResourceUnAvailable - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_S_ResourceUnAvailableQuery extends POQuery<MResourceUnAvailable> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MResourceUnAvailable.Table_Name;
	}

	public CompletableFuture<MResourceUnAvailable> S_ResourceUnAvailable(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MResourceUnAvailable> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_S_ResourceUnAvailableDataLoader.DATALOADER_S_ResourceUnAvailable_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MResourceUnAvailable> S_ResourceUnAvailableGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
