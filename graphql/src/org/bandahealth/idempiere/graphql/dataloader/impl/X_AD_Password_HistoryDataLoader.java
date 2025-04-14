package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPasswordHistory;

/**
 * Data Loader for AD_Password_History - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_Password_HistoryDataLoader extends PODataLoader<MPasswordHistory> {
	public static String DATALOADER_AD_Password_History_BY_ID = "AD_Password_HistoryByIdDataLoader";
	public static String DATALOADER_AD_Password_History_BY_UUID = "AD_Password_HistoryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPasswordHistory.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Password_History_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Password_History_BY_UUID;
	}
}
