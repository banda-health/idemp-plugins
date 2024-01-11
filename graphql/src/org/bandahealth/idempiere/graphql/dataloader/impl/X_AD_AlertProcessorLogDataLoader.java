package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAlertProcessorLog;

/**
 * Data Loader for AD_AlertProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_AlertProcessorLogDataLoader extends PODataLoader<MAlertProcessorLog> {
	public static String AD_AlertProcessorLog_BY_ID_DATA_LOADER = "AD_AlertProcessorLogByIdDataLoader";
	public static String AD_AlertProcessorLog_BY_UUID_DATA_LOADER = "AD_AlertProcessorLogByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAlertProcessorLog.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_AlertProcessorLog_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_AlertProcessorLog_BY_UUID_DATA_LOADER;
	}
}
