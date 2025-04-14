package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_SchedulerDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MScheduler;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Scheduler - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_SchedulerQuery extends POQuery<MScheduler> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MScheduler.Table_Name;
	}

	public CompletableFuture<MScheduler> AD_Scheduler(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MScheduler> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_SchedulerDataLoader.DATALOADER_AD_Scheduler_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MScheduler> AD_SchedulerGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
