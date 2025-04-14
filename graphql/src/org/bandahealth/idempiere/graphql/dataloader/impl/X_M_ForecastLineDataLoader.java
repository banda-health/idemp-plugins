package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MForecastLine;

/**
 * Data Loader for M_ForecastLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_ForecastLineDataLoader extends PODataLoader<MForecastLine> {
	public static String DATALOADER_M_ForecastLine_BY_ID = "M_ForecastLineByIdDataLoader";
	public static String DATALOADER_M_ForecastLine_BY_UUID = "M_ForecastLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MForecastLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_ForecastLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_ForecastLine_BY_UUID;
	}
}
