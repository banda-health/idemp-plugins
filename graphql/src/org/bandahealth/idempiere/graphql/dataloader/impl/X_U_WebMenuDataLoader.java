package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MWebMenu;

/**
 * Data Loader for U_WebMenu - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_U_WebMenuDataLoader extends PODataLoader<MWebMenu> {
	public static String DATALOADER_U_WebMenu_BY_ID = "U_WebMenuByIdDataLoader";
	public static String DATALOADER_U_WebMenu_BY_UUID = "U_WebMenuByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MWebMenu.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_U_WebMenu_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_U_WebMenu_BY_UUID;
	}
}
