package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MForecast;

/**
 * Data Loader for M_Forecast - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ForecastDataLoader extends PODataLoader<MForecast> {
	public static String M_Forecast_BY_ID_DATA_LOADER = "M_ForecastByIdDataLoader";
	public static String M_Forecast_BY_UUID_DATA_LOADER = "M_ForecastByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MForecast.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_Forecast_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_Forecast_BY_UUID_DATA_LOADER;
	}
}
