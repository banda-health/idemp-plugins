package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OnlineTrxHistoryDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MOnlineTrxHistory;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_OnlineTrxHistory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_OnlineTrxHistoryQuery extends POQuery<MOnlineTrxHistory> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MOnlineTrxHistory.Table_Name;
	}

	public CompletableFuture<MOnlineTrxHistory> C_OnlineTrxHistory(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MOnlineTrxHistory> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_OnlineTrxHistoryDataLoader.DATALOADER_C_OnlineTrxHistory_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MOnlineTrxHistory> C_OnlineTrxHistoryGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
