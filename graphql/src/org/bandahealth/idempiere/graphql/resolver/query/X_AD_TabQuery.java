package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TabDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTab;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Tab - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_TabQuery extends POQuery<MTab> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTab.Table_Name;
	}

	public CompletableFuture<MTab> AD_Tab(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MTab> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_TabDataLoader.DATALOADER_AD_Tab_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MTab> AD_TabGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
