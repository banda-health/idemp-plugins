package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_BenchmarkDataLoader;
import org.compiere.model.X_PA_Benchmark;
import org.compiere.model.X_PA_BenchmarkData;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for PA_BenchmarkData - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_BenchmarkDataResolver extends POResolver<X_PA_BenchmarkData> implements GraphQLResolver<X_PA_BenchmarkData> {



	/**
	 * Get Benchmark.
	 *
	 * @return Performance Benchmark
	 */
	public CompletableFuture<X_PA_Benchmark> PA_Benchmark(X_PA_BenchmarkData entity, DataFetchingEnvironment environment) {
		if (entity.getPA_Benchmark_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_PA_Benchmark> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_BenchmarkDataLoader.DATALOADER_PA_Benchmark_BY_ID);
		return dataLoader.load(entity.getPA_Benchmark_ID());
	}

}
