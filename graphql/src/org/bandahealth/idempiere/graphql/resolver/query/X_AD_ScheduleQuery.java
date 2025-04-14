package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ScheduleDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MSchedule;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Schedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_ScheduleQuery extends POQuery<MSchedule> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MSchedule.Table_Name;
	}

	public CompletableFuture<MSchedule> AD_Schedule(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MSchedule> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_ScheduleDataLoader.DATALOADER_AD_Schedule_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MSchedule> AD_ScheduleGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
