package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MForecast;

/**
 * Data Loader for M_Forecast - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_ForecastDataLoader extends PODataLoader<MForecast> {
	public static String DATALOADER_M_Forecast_BY_ID = "M_ForecastByIdDataLoader";
	public static String DATALOADER_M_Forecast_BY_UUID = "M_ForecastByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MForecast.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_Forecast_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_Forecast_BY_UUID;
	}
}
