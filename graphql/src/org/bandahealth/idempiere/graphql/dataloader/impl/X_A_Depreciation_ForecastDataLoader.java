package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_A_Depreciation_Forecast;

/**
 * Data Loader for A_Depreciation_Forecast - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Depreciation_ForecastDataLoader extends PODataLoader<X_A_Depreciation_Forecast> {
	public static String DATALOADER_A_Depreciation_Forecast_BY_ID = "A_Depreciation_ForecastByIdDataLoader";
	public static String DATALOADER_A_Depreciation_Forecast_BY_UUID = "A_Depreciation_ForecastByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_A_Depreciation_Forecast.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_A_Depreciation_Forecast_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_A_Depreciation_Forecast_BY_UUID;
	}
}
