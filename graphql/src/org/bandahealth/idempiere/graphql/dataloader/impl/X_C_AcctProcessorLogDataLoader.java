package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAcctProcessorLog;

/**
 * Data Loader for C_AcctProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_AcctProcessorLogDataLoader extends PODataLoader<MAcctProcessorLog> {
	public static String DATALOADER_C_AcctProcessorLog_BY_ID = "C_AcctProcessorLogByIdDataLoader";
	public static String DATALOADER_C_AcctProcessorLog_BY_UUID = "C_AcctProcessorLogByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAcctProcessorLog.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_AcctProcessorLog_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_AcctProcessorLog_BY_UUID;
	}
}
