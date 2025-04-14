package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_ASP_WindowDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_ASP_Window;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for ASP_Window - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_ASP_WindowQuery extends POQuery<X_ASP_Window> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_ASP_Window.Table_Name;
	}

	public CompletableFuture<X_ASP_Window> ASP_Window(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_ASP_Window> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_ASP_WindowDataLoader.DATALOADER_ASP_Window_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_ASP_Window> ASP_WindowGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
