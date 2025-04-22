package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Asset_DisposedDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAssetDisposed;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for A_Asset_Disposed - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_A_Asset_DisposedQuery extends POQuery<MAssetDisposed> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAssetDisposed.Table_Name;
	}

	public CompletableFuture<MAssetDisposed> A_Asset_Disposed(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MAssetDisposed> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_A_Asset_DisposedDataLoader.DATALOADER_A_Asset_Disposed_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MAssetDisposed> A_Asset_DisposedGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
