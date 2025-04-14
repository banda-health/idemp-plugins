package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CycleStepDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_CycleStep;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_CycleStep - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_CycleStepQuery extends POQuery<X_C_CycleStep> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_CycleStep.Table_Name;
	}

	public CompletableFuture<X_C_CycleStep> C_CycleStep(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_C_CycleStep> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_CycleStepDataLoader.DATALOADER_C_CycleStep_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_C_CycleStep> C_CycleStepGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
