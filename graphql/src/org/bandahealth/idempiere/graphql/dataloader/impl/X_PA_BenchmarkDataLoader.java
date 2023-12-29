package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_PA_Benchmark;

/**
 * Data Loader for PA_Benchmark - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_BenchmarkDataLoader extends PODataLoader<X_PA_Benchmark> {
	public static String PA_Benchmark_BY_ID_DATA_LOADER = "PA_BenchmarkByIdDataLoader";
	public static String PA_Benchmark_BY_UUID_DATA_LOADER = "PA_BenchmarkByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_PA_Benchmark.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return PA_Benchmark_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return PA_Benchmark_BY_UUID_DATA_LOADER;
	}
}
