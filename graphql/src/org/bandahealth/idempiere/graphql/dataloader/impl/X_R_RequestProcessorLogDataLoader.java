package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRequestProcessorLog;

/**
 * Data Loader for R_RequestProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_R_RequestProcessorLogDataLoader extends PODataLoader<MRequestProcessorLog> {
	public static String DATALOADER_R_RequestProcessorLog_BY_ID = "R_RequestProcessorLogByIdDataLoader";
	public static String DATALOADER_R_RequestProcessorLog_BY_UUID = "R_RequestProcessorLogByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRequestProcessorLog.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_R_RequestProcessorLog_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_R_RequestProcessorLog_BY_UUID;
	}
}
