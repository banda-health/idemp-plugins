package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_BenchmarkDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_PA_Benchmark;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for PA_Benchmark - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_BenchmarkQuery extends POQuery<X_PA_Benchmark> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_PA_Benchmark.Table_Name;
	}

	public CompletableFuture<X_PA_Benchmark> PA_Benchmark(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_PA_Benchmark> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PA_BenchmarkDataLoader.DATALOADER_PA_Benchmark_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_PA_Benchmark> PA_BenchmarkGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
