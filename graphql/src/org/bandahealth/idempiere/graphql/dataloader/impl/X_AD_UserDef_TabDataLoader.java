package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MUserDefTab_BH;

/**
 * Data Loader for AD_UserDef_Tab - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_UserDef_TabDataLoader extends PODataLoader<MUserDefTab_BH> {
	public static String DATALOADER_AD_UserDef_Tab_BY_ID = "AD_UserDef_TabByIdDataLoader";
	public static String DATALOADER_AD_UserDef_Tab_BY_UUID = "AD_UserDef_TabByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MUserDefTab_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_UserDef_Tab_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_UserDef_Tab_BY_UUID;
	}
}
