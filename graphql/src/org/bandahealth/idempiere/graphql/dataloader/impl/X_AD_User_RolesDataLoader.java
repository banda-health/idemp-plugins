package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MUserRoles;

/**
 * Data Loader for AD_User_Roles - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_User_RolesDataLoader extends PODataLoader<MUserRoles> {
	public static String DATALOADER_AD_User_Roles_BY_ID = "AD_User_RolesByIdDataLoader";
	public static String DATALOADER_AD_User_Roles_BY_UUID = "AD_User_RolesByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MUserRoles.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_User_Roles_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_User_Roles_BY_UUID;
	}
}
