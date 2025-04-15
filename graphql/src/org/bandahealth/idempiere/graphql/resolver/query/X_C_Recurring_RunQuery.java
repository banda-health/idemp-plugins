package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_Recurring_RunDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRecurringRun;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_Recurring_Run - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_Recurring_RunQuery extends POQuery<MRecurringRun> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRecurringRun.Table_Name;
	}

	public CompletableFuture<MRecurringRun> C_Recurring_Run(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MRecurringRun> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_Recurring_RunDataLoader.DATALOADER_C_Recurring_Run_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MRecurringRun> C_Recurring_RunGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
