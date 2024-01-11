package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MForecastLine;

/**
 * Data Loader for M_ForecastLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ForecastLineDataLoader extends PODataLoader<MForecastLine> {
	public static String M_ForecastLine_BY_ID_DATA_LOADER = "M_ForecastLineByIdDataLoader";
	public static String M_ForecastLine_BY_UUID_DATA_LOADER = "M_ForecastLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MForecastLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_ForecastLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_ForecastLine_BY_UUID_DATA_LOADER;
	}
}
