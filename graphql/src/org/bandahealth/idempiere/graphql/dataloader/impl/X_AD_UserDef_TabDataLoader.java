package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MUserDefTab;

/**
 * Data Loader for AD_UserDef_Tab - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_UserDef_TabDataLoader extends PODataLoader<MUserDefTab> {
	public static String AD_UserDef_Tab_BY_ID_DATA_LOADER = "AD_UserDef_TabByIdDataLoader";
	public static String AD_UserDef_Tab_BY_UUID_DATA_LOADER = "AD_UserDef_TabByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MUserDefTab.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_UserDef_Tab_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_UserDef_Tab_BY_UUID_DATA_LOADER;
	}
}
