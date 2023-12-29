package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_PrintFont;

/**
 * Data Loader for AD_PrintFont - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_PrintFontDataLoader extends PODataLoader<X_AD_PrintFont> {
	public static String AD_PrintFont_BY_ID_DATA_LOADER = "AD_PrintFontByIdDataLoader";
	public static String AD_PrintFont_BY_UUID_DATA_LOADER = "AD_PrintFontByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_PrintFont.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_PrintFont_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_PrintFont_BY_UUID_DATA_LOADER;
	}
}
