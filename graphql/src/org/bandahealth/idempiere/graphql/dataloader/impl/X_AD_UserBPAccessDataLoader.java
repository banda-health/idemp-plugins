package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_UserBPAccess;

/**
 * Data Loader for AD_UserBPAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_UserBPAccessDataLoader extends PODataLoader<X_AD_UserBPAccess> {
	public static String DATALOADER_AD_UserBPAccess_BY_ID = "AD_UserBPAccessByIdDataLoader";
	public static String DATALOADER_AD_UserBPAccess_BY_UUID = "AD_UserBPAccessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_UserBPAccess.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_UserBPAccess_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_UserBPAccess_BY_UUID;
	}
}
