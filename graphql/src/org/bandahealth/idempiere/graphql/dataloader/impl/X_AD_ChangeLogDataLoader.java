package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MChangeLog;

/**
 * Data Loader for AD_ChangeLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_ChangeLogDataLoader extends PODataLoader<MChangeLog> {
	public static String DATALOADER_AD_ChangeLog_BY_ID = "AD_ChangeLogByIdDataLoader";
	public static String DATALOADER_AD_ChangeLog_BY_UUID = "AD_ChangeLogByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MChangeLog.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_ChangeLog_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_ChangeLog_BY_UUID;
	}
}
