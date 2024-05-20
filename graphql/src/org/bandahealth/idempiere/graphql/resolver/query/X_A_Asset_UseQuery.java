package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Asset_UseDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAssetUse;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for A_Asset_Use - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Asset_UseQuery extends POQuery<MAssetUse> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAssetUse.Table_Name;
	}

	public CompletableFuture<MAssetUse> A_Asset_Use(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MAssetUse> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_A_Asset_UseDataLoader.DATALOADER_A_Asset_Use_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MAssetUse> A_Asset_UseGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
