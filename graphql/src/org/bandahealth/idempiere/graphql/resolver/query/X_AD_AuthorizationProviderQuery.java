package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_AuthorizationProviderDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAuthorizationProvider;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_AuthorizationProvider - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_AuthorizationProviderQuery extends POQuery<MAuthorizationProvider> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAuthorizationProvider.Table_Name;
	}

	public CompletableFuture<MAuthorizationProvider> AD_AuthorizationProvider(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MAuthorizationProvider> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_AuthorizationProviderDataLoader.DATALOADER_AD_AuthorizationProvider_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MAuthorizationProvider> AD_AuthorizationProviderGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
