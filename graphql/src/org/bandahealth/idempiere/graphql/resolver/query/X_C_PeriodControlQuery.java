package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PeriodControlDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPeriodControl;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_PeriodControl - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_PeriodControlQuery extends POQuery<MPeriodControl> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPeriodControl.Table_Name;
	}

	public CompletableFuture<MPeriodControl> C_PeriodControl(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MPeriodControl> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_PeriodControlDataLoader.DATALOADER_C_PeriodControl_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MPeriodControl> C_PeriodControlGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
