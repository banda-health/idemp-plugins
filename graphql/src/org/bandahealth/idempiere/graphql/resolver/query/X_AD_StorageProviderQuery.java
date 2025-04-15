package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_StorageProviderDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MStorageProvider;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_StorageProvider - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_StorageProviderQuery extends POQuery<MStorageProvider> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MStorageProvider.Table_Name;
	}

	public CompletableFuture<MStorageProvider> AD_StorageProvider(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MStorageProvider> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_StorageProviderDataLoader.DATALOADER_AD_StorageProvider_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MStorageProvider> AD_StorageProviderGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
