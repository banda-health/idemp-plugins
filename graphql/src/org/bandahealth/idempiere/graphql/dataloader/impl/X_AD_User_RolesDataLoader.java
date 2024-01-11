package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MUserRoles;

/**
 * Data Loader for AD_User_Roles - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_User_RolesDataLoader extends PODataLoader<MUserRoles> {
	public static String AD_User_Roles_BY_ID_DATA_LOADER = "AD_User_RolesByIdDataLoader";
	public static String AD_User_Roles_BY_UUID_DATA_LOADER = "AD_User_RolesByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MUserRoles.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_User_Roles_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_User_Roles_BY_UUID_DATA_LOADER;
	}
}
