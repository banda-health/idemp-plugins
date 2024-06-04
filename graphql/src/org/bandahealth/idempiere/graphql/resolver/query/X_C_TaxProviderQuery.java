package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxProviderDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTaxProvider;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_TaxProvider - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_TaxProviderQuery extends POQuery<MTaxProvider> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTaxProvider.Table_Name;
	}

	public CompletableFuture<MTaxProvider> C_TaxProvider(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MTaxProvider> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_TaxProviderDataLoader.DATALOADER_C_TaxProvider_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MTaxProvider> C_TaxProviderGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
