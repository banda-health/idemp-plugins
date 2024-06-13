package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ViewColumnDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MViewColumn;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_ViewColumn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_ViewColumnQuery extends POQuery<MViewColumn> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MViewColumn.Table_Name;
	}

	public CompletableFuture<MViewColumn> AD_ViewColumn(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MViewColumn> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_ViewColumnDataLoader.DATALOADER_AD_ViewColumn_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MViewColumn> AD_ViewColumnGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
