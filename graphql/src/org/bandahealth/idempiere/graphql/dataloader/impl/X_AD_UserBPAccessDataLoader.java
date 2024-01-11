package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MUserBPAccess;

/**
 * Data Loader for AD_UserBPAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_UserBPAccessDataLoader extends PODataLoader<MUserBPAccess> {
	public static String AD_UserBPAccess_BY_ID_DATA_LOADER = "AD_UserBPAccessByIdDataLoader";
	public static String AD_UserBPAccess_BY_UUID_DATA_LOADER = "AD_UserBPAccessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MUserBPAccess.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_UserBPAccess_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_UserBPAccess_BY_UUID_DATA_LOADER;
	}
}
