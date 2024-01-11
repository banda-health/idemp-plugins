package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MUserDefInfo;

/**
 * Data Loader for AD_UserDef_Info - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_UserDef_InfoDataLoader extends PODataLoader<MUserDefInfo> {
	public static String AD_UserDef_Info_BY_ID_DATA_LOADER = "AD_UserDef_InfoByIdDataLoader";
	public static String AD_UserDef_Info_BY_UUID_DATA_LOADER = "AD_UserDef_InfoByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MUserDefInfo.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_UserDef_Info_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_UserDef_Info_BY_UUID_DATA_LOADER;
	}
}
