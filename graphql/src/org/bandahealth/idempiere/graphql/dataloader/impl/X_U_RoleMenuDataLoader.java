package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_U_RoleMenu;

/**
 * Data Loader for U_RoleMenu - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_U_RoleMenuDataLoader extends PODataLoader<X_U_RoleMenu> {
	public static String DATALOADER_U_RoleMenu_BY_ID = "U_RoleMenuByIdDataLoader";
	public static String DATALOADER_U_RoleMenu_BY_UUID = "U_RoleMenuByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_U_RoleMenu.Table_Name;
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
