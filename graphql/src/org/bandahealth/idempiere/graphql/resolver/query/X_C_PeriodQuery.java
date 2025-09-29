package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PeriodDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPeriod;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_Period - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_PeriodQuery extends POQuery<MPeriod> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPeriod.Table_Name;
	}

	public CompletableFuture<MPeriod> C_Period(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MPeriod> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_PeriodDataLoader.DATALOADER_C_Period_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MPeriod> C_PeriodGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
