package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_PA_Benchmark;

/**
 * Data Loader for PA_Benchmark - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_PA_BenchmarkDataLoader extends PODataLoader<X_PA_Benchmark> {
	public static String DATALOADER_PA_Benchmark_BY_ID = "PA_BenchmarkByIdDataLoader";
	public static String DATALOADER_PA_Benchmark_BY_UUID = "PA_BenchmarkByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_PA_Benchmark.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_PA_Benchmark_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_PA_Benchmark_BY_UUID;
	}
}
