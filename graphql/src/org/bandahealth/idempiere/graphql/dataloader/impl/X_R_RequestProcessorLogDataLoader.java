package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRequestProcessorLog;

/**
 * Data Loader for R_RequestProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_RequestProcessorLogDataLoader extends PODataLoader<MRequestProcessorLog> {
	public static String R_RequestProcessorLog_BY_ID_DATA_LOADER = "R_RequestProcessorLogByIdDataLoader";
	public static String R_RequestProcessorLog_BY_UUID_DATA_LOADER = "R_RequestProcessorLogByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRequestProcessorLog.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return R_RequestProcessorLog_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return R_RequestProcessorLog_BY_UUID_DATA_LOADER;
	}
}
