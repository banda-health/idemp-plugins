package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRoleOrgAccess;

/**
 * Data Loader for AD_Role_OrgAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_Role_OrgAccessDataLoader extends PODataLoader<MRoleOrgAccess> {
	public static String DATALOADER_AD_Role_OrgAccess_BY_ID = "AD_Role_OrgAccessByIdDataLoader";
	public static String DATALOADER_AD_Role_OrgAccess_BY_UUID = "AD_Role_OrgAccessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRoleOrgAccess.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Role_OrgAccess_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Role_OrgAccess_BY_UUID;
	}
}
