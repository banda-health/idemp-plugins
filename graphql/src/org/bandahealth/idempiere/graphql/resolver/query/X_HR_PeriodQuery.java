package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_PeriodDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;
import org.eevolution.model.X_HR_Period;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for HR_Period - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_HR_PeriodQuery extends POQuery<X_HR_Period> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_HR_Period.Table_Name;
	}

	public CompletableFuture<X_HR_Period> HR_Period(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_HR_Period> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_HR_PeriodDataLoader.DATALOADER_HR_Period_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_HR_Period> HR_PeriodGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
