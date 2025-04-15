package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_PrintFormatItem;

/**
 * Data Loader for AD_PrintFormatItem - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_PrintFormatItemDataLoader extends PODataLoader<X_AD_PrintFormatItem> {
	public static String DATALOADER_AD_PrintFormatItem_BY_ID = "AD_PrintFormatItemByIdDataLoader";
	public static String DATALOADER_AD_PrintFormatItem_BY_UUID = "AD_PrintFormatItemByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_PrintFormatItem.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_PrintFormatItem_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_PrintFormatItem_BY_UUID;
	}
}
