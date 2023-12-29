package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MUser_BH;

/**
 * Data Loader for AD_User - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_UserDataLoader extends PODataLoader<MUser_BH> {
	public static String AD_User_BY_ID_DATA_LOADER = "AD_UserByIdDataLoader";
	public static String AD_User_BY_UUID_DATA_LOADER = "AD_UserByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MUser_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_User_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_User_BY_UUID_DATA_LOADER;
	}
}
