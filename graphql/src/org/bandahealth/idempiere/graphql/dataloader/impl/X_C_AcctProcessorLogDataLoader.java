package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAcctProcessorLog;

/**
 * Data Loader for C_AcctProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_AcctProcessorLogDataLoader extends PODataLoader<MAcctProcessorLog> {
	public static String C_AcctProcessorLog_BY_ID_DATA_LOADER = "C_AcctProcessorLogByIdDataLoader";
	public static String C_AcctProcessorLog_BY_UUID_DATA_LOADER = "C_AcctProcessorLogByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAcctProcessorLog.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_AcctProcessorLog_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_AcctProcessorLog_BY_UUID_DATA_LOADER;
	}
}
