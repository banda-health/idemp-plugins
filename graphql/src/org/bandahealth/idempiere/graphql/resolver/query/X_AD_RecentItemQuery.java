package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_RecentItemDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRecentItem;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_RecentItem - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_RecentItemQuery extends POQuery<MRecentItem> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRecentItem.Table_Name;
	}

	public CompletableFuture<MRecentItem> AD_RecentItem(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MRecentItem> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_RecentItemDataLoader.DATALOADER_AD_RecentItem_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MRecentItem> AD_RecentItemGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
