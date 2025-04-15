package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PayScheduleDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPaySchedule;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_PaySchedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_PayScheduleQuery extends POQuery<MPaySchedule> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPaySchedule.Table_Name;
	}

	public CompletableFuture<MPaySchedule> C_PaySchedule(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MPaySchedule> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_PayScheduleDataLoader.DATALOADER_C_PaySchedule_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MPaySchedule> C_PayScheduleGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
