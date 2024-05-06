package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRoleMenu;

/**
 * Data Loader for U_RoleMenu - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_U_RoleMenuDataLoader extends PODataLoader<MRoleMenu> {
	public static String DATALOADER_U_RoleMenu_BY_ID = "U_RoleMenuByIdDataLoader";
	public static String DATALOADER_U_RoleMenu_BY_UUID = "U_RoleMenuByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRoleMenu.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_U_RoleMenu_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_U_RoleMenu_BY_UUID;
	}
}
