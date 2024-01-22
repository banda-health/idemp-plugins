package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MOnlineTrxHistory;

/**
 * Data Loader for C_OnlineTrxHistory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_OnlineTrxHistoryDataLoader extends PODataLoader<MOnlineTrxHistory> {
	public static String DATALOADER_C_OnlineTrxHistory_BY_ID = "C_OnlineTrxHistoryByIdDataLoader";
	public static String DATALOADER_C_OnlineTrxHistory_BY_UUID = "C_OnlineTrxHistoryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MOnlineTrxHistory.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_OnlineTrxHistory_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_OnlineTrxHistory_BY_UUID;
	}
}
