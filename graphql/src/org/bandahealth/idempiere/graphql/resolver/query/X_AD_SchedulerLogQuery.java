package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_SchedulerLogDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MSchedulerLog;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_SchedulerLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_SchedulerLogQuery extends POQuery<MSchedulerLog> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MSchedulerLog.Table_Name;
	}

	public CompletableFuture<MSchedulerLog> AD_SchedulerLog(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MSchedulerLog> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_SchedulerLogDataLoader.DATALOADER_AD_SchedulerLog_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MSchedulerLog> AD_SchedulerLogGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
