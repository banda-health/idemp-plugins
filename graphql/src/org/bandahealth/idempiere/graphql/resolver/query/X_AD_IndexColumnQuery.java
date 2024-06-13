package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_IndexColumnDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MIndexColumn;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_IndexColumn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_IndexColumnQuery extends POQuery<MIndexColumn> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MIndexColumn.Table_Name;
	}

	public CompletableFuture<MIndexColumn> AD_IndexColumn(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MIndexColumn> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_IndexColumnDataLoader.DATALOADER_AD_IndexColumn_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MIndexColumn> AD_IndexColumnGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
