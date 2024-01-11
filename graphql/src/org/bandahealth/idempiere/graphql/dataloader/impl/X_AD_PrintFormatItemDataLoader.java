package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_PrintFormatItem;

/**
 * Data Loader for AD_PrintFormatItem - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_PrintFormatItemDataLoader extends PODataLoader<X_AD_PrintFormatItem> {
	public static String AD_PrintFormatItem_BY_ID_DATA_LOADER = "AD_PrintFormatItemByIdDataLoader";
	public static String AD_PrintFormatItem_BY_UUID_DATA_LOADER = "AD_PrintFormatItemByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_PrintFormatItem.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_PrintFormatItem_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_PrintFormatItem_BY_UUID_DATA_LOADER;
	}
}
