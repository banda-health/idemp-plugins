package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_U_WebMenu;

/**
 * Data Loader for U_WebMenu - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_U_WebMenuDataLoader extends PODataLoader<X_U_WebMenu> {
	public static String DATALOADER_U_WebMenu_BY_ID = "U_WebMenuByIdDataLoader";
	public static String DATALOADER_U_WebMenu_BY_UUID = "U_WebMenuByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_U_WebMenu.Table_Name;
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
