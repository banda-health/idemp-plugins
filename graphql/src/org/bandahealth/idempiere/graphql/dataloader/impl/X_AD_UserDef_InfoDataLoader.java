package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MUserDefInfo;

/**
 * Data Loader for AD_UserDef_Info - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_UserDef_InfoDataLoader extends PODataLoader<MUserDefInfo> {
	public static String DATALOADER_AD_UserDef_Info_BY_ID = "AD_UserDef_InfoByIdDataLoader";
	public static String DATALOADER_AD_UserDef_Info_BY_UUID = "AD_UserDef_InfoByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MUserDefInfo.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_UserDef_Info_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_UserDef_Info_BY_UUID;
	}
}
