package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_InfoColumnDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MInfoColumn;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_InfoColumn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_InfoColumnQuery extends POQuery<MInfoColumn> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MInfoColumn.Table_Name;
	}

	public CompletableFuture<MInfoColumn> AD_InfoColumn(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MInfoColumn> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_InfoColumnDataLoader.DATALOADER_AD_InfoColumn_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MInfoColumn> AD_InfoColumnGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
