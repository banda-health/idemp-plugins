package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_PrintFont;

/**
 * Data Loader for AD_PrintFont - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_PrintFontDataLoader extends PODataLoader<X_AD_PrintFont> {
	public static String DATALOADER_AD_PrintFont_BY_ID = "AD_PrintFontByIdDataLoader";
	public static String DATALOADER_AD_PrintFont_BY_UUID = "AD_PrintFontByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_PrintFont.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_PrintFont_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_PrintFont_BY_UUID;
	}
}
