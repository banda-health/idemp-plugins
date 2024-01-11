package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MMenu_BH;

/**
 * Data Loader for AD_Menu - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_MenuDataLoader extends PODataLoader<MMenu_BH> {
	public static String AD_Menu_BY_ID_DATA_LOADER = "AD_MenuByIdDataLoader";
	public static String AD_Menu_BY_UUID_DATA_LOADER = "AD_MenuByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MMenu_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Menu_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Menu_BY_UUID_DATA_LOADER;
	}
}
