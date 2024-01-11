package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MUserDefWin;

/**
 * Data Loader for AD_UserDef_Win - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_UserDef_WinDataLoader extends PODataLoader<MUserDefWin> {
	public static String AD_UserDef_Win_BY_ID_DATA_LOADER = "AD_UserDef_WinByIdDataLoader";
	public static String AD_UserDef_Win_BY_UUID_DATA_LOADER = "AD_UserDef_WinByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MUserDefWin.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_UserDef_Win_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_UserDef_Win_BY_UUID_DATA_LOADER;
	}
}
