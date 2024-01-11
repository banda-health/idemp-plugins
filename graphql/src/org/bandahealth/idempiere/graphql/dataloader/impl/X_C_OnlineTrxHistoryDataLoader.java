package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MOnlineTrxHistory;

/**
 * Data Loader for C_OnlineTrxHistory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_OnlineTrxHistoryDataLoader extends PODataLoader<MOnlineTrxHistory> {
	public static String C_OnlineTrxHistory_BY_ID_DATA_LOADER = "C_OnlineTrxHistoryByIdDataLoader";
	public static String C_OnlineTrxHistory_BY_UUID_DATA_LOADER = "C_OnlineTrxHistoryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MOnlineTrxHistory.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_OnlineTrxHistory_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_OnlineTrxHistory_BY_UUID_DATA_LOADER;
	}
}
