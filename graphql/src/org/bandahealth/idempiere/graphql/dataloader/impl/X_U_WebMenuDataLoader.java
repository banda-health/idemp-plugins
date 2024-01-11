package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MWebMenu;

/**
 * Data Loader for U_WebMenu - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_U_WebMenuDataLoader extends PODataLoader<MWebMenu> {
	public static String U_WebMenu_BY_ID_DATA_LOADER = "U_WebMenuByIdDataLoader";
	public static String U_WebMenu_BY_UUID_DATA_LOADER = "U_WebMenuByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MWebMenu.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return U_WebMenu_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return U_WebMenu_BY_UUID_DATA_LOADER;
	}
}
