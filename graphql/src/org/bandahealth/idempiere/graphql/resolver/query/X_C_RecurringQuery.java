package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_RecurringDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRecurring;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_Recurring - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_RecurringQuery extends POQuery<MRecurring> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRecurring.Table_Name;
	}

	public CompletableFuture<MRecurring> C_Recurring(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MRecurring> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_RecurringDataLoader.DATALOADER_C_Recurring_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MRecurring> C_RecurringGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
