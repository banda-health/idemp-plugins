package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CalendarDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCalendar;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_Calendar - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_CalendarQuery extends POQuery<MCalendar> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCalendar.Table_Name;
	}

	public CompletableFuture<MCalendar> C_Calendar(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MCalendar> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_CalendarDataLoader.DATALOADER_C_Calendar_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MCalendar> C_CalendarGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
