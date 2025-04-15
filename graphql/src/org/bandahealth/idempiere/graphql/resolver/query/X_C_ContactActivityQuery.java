package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ContactActivityDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_ContactActivity;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_ContactActivity - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_ContactActivityQuery extends POQuery<X_C_ContactActivity> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_ContactActivity.Table_Name;
	}

	public CompletableFuture<X_C_ContactActivity> C_ContactActivity(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_C_ContactActivity> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_ContactActivityDataLoader.DATALOADER_C_ContactActivity_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_C_ContactActivity> C_ContactActivityGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
