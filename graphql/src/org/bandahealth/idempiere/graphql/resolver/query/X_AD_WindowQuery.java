package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WindowDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MWindow;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Window - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_WindowQuery extends POQuery<MWindow> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MWindow.Table_Name;
	}

	public CompletableFuture<MWindow> AD_Window(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MWindow> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_WindowDataLoader.DATALOADER_AD_Window_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MWindow> AD_WindowGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
