package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MUser_BH;

/**
 * Data Loader for AD_User - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_UserDataLoader extends PODataLoader<MUser_BH> {
	public static String DATALOADER_AD_User_BY_ID = "AD_UserByIdDataLoader";
	public static String DATALOADER_AD_User_BY_UUID = "AD_UserByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MUser_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_User_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_User_BY_UUID;
	}
}
