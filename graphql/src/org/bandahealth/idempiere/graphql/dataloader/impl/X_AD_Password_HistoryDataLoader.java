package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPasswordHistory;

/**
 * Data Loader for AD_Password_History - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Password_HistoryDataLoader extends PODataLoader<MPasswordHistory> {
	public static String AD_Password_History_BY_ID_DATA_LOADER = "AD_Password_HistoryByIdDataLoader";
	public static String AD_Password_History_BY_UUID_DATA_LOADER = "AD_Password_HistoryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPasswordHistory.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Password_History_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Password_History_BY_UUID_DATA_LOADER;
	}
}
