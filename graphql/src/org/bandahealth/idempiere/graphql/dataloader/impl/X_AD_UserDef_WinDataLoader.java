package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MUserDefWin;

/**
 * Data Loader for AD_UserDef_Win - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_UserDef_WinDataLoader extends PODataLoader<MUserDefWin> {
	public static String DATALOADER_AD_UserDef_Win_BY_ID = "AD_UserDef_WinByIdDataLoader";
	public static String DATALOADER_AD_UserDef_Win_BY_UUID = "AD_UserDef_WinByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MUserDefWin.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_UserDef_Win_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_UserDef_Win_BY_UUID;
	}
}
