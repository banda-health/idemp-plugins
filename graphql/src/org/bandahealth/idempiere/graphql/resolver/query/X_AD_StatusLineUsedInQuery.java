package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_StatusLineUsedInDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MStatusLineUsedIn;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_StatusLineUsedIn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_StatusLineUsedInQuery extends POQuery<MStatusLineUsedIn> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MStatusLineUsedIn.Table_Name;
	}

	public CompletableFuture<MStatusLineUsedIn> AD_StatusLineUsedIn(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MStatusLineUsedIn> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_StatusLineUsedInDataLoader.DATALOADER_AD_StatusLineUsedIn_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MStatusLineUsedIn> AD_StatusLineUsedInGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
