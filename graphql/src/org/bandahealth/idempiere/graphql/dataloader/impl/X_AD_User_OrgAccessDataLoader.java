package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MUserOrgAccess;

/**
 * Data Loader for AD_User_OrgAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_User_OrgAccessDataLoader extends PODataLoader<MUserOrgAccess> {
	public static String DATALOADER_AD_User_OrgAccess_BY_ID = "AD_User_OrgAccessByIdDataLoader";
	public static String DATALOADER_AD_User_OrgAccess_BY_UUID = "AD_User_OrgAccessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MUserOrgAccess.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_User_OrgAccess_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_User_OrgAccess_BY_UUID;
	}
}
