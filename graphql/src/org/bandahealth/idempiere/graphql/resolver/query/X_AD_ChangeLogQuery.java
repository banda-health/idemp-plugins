package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ChangeLogDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MChangeLog;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_ChangeLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_ChangeLogQuery extends POQuery<MChangeLog> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MChangeLog.Table_Name;
	}

	public CompletableFuture<MChangeLog> AD_ChangeLog(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MChangeLog> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_ChangeLogDataLoader.DATALOADER_AD_ChangeLog_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MChangeLog> AD_ChangeLogGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
