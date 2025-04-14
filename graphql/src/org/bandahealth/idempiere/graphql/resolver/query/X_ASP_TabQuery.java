package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_ASP_TabDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_ASP_Tab;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for ASP_Tab - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_ASP_TabQuery extends POQuery<X_ASP_Tab> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_ASP_Tab.Table_Name;
	}

	public CompletableFuture<X_ASP_Tab> ASP_Tab(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_ASP_Tab> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_ASP_TabDataLoader.DATALOADER_ASP_Tab_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_ASP_Tab> ASP_TabGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
