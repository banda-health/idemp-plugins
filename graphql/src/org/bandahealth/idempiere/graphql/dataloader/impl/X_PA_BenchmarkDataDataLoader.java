package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_PA_BenchmarkData;

/**
 * Data Loader for PA_BenchmarkData - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_PA_BenchmarkDataDataLoader extends PODataLoader<X_PA_BenchmarkData> {
	public static String DATALOADER_PA_BenchmarkData_BY_ID = "PA_BenchmarkDataByIdDataLoader";
	public static String DATALOADER_PA_BenchmarkData_BY_UUID = "PA_BenchmarkDataByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_PA_BenchmarkData.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_PA_BenchmarkData_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_PA_BenchmarkData_BY_UUID;
	}
}
