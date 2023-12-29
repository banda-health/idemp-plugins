package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_PA_BenchmarkData;

/**
 * Data Loader for PA_BenchmarkData - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_BenchmarkDataDataLoader extends PODataLoader<X_PA_BenchmarkData> {
	public static String PA_BenchmarkData_BY_ID_DATA_LOADER = "PA_BenchmarkDataByIdDataLoader";
	public static String PA_BenchmarkData_BY_UUID_DATA_LOADER = "PA_BenchmarkDataByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_PA_BenchmarkData.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return PA_BenchmarkData_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return PA_BenchmarkData_BY_UUID_DATA_LOADER;
	}
}
