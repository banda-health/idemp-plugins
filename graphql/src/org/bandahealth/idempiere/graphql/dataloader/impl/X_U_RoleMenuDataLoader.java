package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRoleMenu;

/**
 * Data Loader for U_RoleMenu - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_U_RoleMenuDataLoader extends PODataLoader<MRoleMenu> {
	public static String U_RoleMenu_BY_ID_DATA_LOADER = "U_RoleMenuByIdDataLoader";
	public static String U_RoleMenu_BY_UUID_DATA_LOADER = "U_RoleMenuByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRoleMenu.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return U_RoleMenu_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return U_RoleMenu_BY_UUID_DATA_LOADER;
	}
}
