package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ActivityDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MActivity;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_Activity - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_ActivityQuery extends POQuery<MActivity> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MActivity.Table_Name;
	}

	public CompletableFuture<MActivity> C_Activity(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MActivity> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_ActivityDataLoader.DATALOADER_C_Activity_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MActivity> C_ActivityGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
