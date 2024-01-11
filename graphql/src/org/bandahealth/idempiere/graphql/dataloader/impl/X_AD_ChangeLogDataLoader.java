package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MChangeLog;

/**
 * Data Loader for AD_ChangeLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ChangeLogDataLoader extends PODataLoader<MChangeLog> {
	public static String AD_ChangeLog_BY_ID_DATA_LOADER = "AD_ChangeLogByIdDataLoader";
	public static String AD_ChangeLog_BY_UUID_DATA_LOADER = "AD_ChangeLogByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MChangeLog.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_ChangeLog_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_ChangeLog_BY_UUID_DATA_LOADER;
	}
}
