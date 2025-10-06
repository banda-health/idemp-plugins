package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Password_HistoryDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPasswordHistory;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Password_History - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_Password_HistoryQuery extends POQuery<MPasswordHistory> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPasswordHistory.Table_Name;
	}

	public CompletableFuture<MPasswordHistory> AD_Password_History(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MPasswordHistory> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Password_HistoryDataLoader.DATALOADER_AD_Password_History_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MPasswordHistory> AD_Password_HistoryGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
