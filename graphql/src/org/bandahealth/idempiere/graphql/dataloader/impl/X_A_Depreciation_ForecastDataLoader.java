package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_A_Depreciation_Forecast;

/**
 * Data Loader for A_Depreciation_Forecast - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Depreciation_ForecastDataLoader extends PODataLoader<X_A_Depreciation_Forecast> {
	public static String A_Depreciation_Forecast_BY_ID_DATA_LOADER = "A_Depreciation_ForecastByIdDataLoader";
	public static String A_Depreciation_Forecast_BY_UUID_DATA_LOADER = "A_Depreciation_ForecastByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_A_Depreciation_Forecast.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return A_Depreciation_Forecast_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return A_Depreciation_Forecast_BY_UUID_DATA_LOADER;
	}
}
