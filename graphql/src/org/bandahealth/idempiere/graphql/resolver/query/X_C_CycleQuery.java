package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CycleDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_Cycle;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_Cycle - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_CycleQuery extends POQuery<X_C_Cycle> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_Cycle.Table_Name;
	}

	public CompletableFuture<X_C_Cycle> C_Cycle(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_C_Cycle> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_CycleDataLoader.DATALOADER_C_Cycle_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_C_Cycle> C_CycleGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
