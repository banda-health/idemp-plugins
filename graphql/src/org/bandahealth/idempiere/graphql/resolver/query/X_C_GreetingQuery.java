package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_GreetingDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_Greeting;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_Greeting - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_GreetingQuery extends POQuery<X_C_Greeting> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_Greeting.Table_Name;
	}

	public CompletableFuture<X_C_Greeting> C_Greeting(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_C_Greeting> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_GreetingDataLoader.DATALOADER_C_Greeting_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_C_Greeting> C_GreetingGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
