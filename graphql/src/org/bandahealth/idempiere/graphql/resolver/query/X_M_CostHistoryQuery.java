package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_CostHistoryDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCostHistory;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_CostHistory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_CostHistoryQuery extends POQuery<MCostHistory> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCostHistory.Table_Name;
	}

	public CompletableFuture<MCostHistory> M_CostHistory(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MCostHistory> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_CostHistoryDataLoader.DATALOADER_M_CostHistory_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MCostHistory> M_CostHistoryGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
