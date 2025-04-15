package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctProcessorLogDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAcctProcessorLog;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_AcctProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_AcctProcessorLogQuery extends POQuery<MAcctProcessorLog> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAcctProcessorLog.Table_Name;
	}

	public CompletableFuture<MAcctProcessorLog> C_AcctProcessorLog(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MAcctProcessorLog> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_AcctProcessorLogDataLoader.DATALOADER_C_AcctProcessorLog_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MAcctProcessorLog> C_AcctProcessorLogGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
