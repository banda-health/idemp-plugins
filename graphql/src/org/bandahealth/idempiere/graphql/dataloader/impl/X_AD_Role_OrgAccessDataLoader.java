package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRoleOrgAccess;

/**
 * Data Loader for AD_Role_OrgAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Role_OrgAccessDataLoader extends PODataLoader<MRoleOrgAccess> {
	public static String AD_Role_OrgAccess_BY_ID_DATA_LOADER = "AD_Role_OrgAccessByIdDataLoader";
	public static String AD_Role_OrgAccess_BY_UUID_DATA_LOADER = "AD_Role_OrgAccessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRoleOrgAccess.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Role_OrgAccess_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Role_OrgAccess_BY_UUID_DATA_LOADER;
	}
}
