package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_PrintFormat;

/**
 * Data Loader for AD_PrintFormat - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_PrintFormatDataLoader extends PODataLoader<X_AD_PrintFormat> {
	public static String DATALOADER_AD_PrintFormat_BY_ID = "AD_PrintFormatByIdDataLoader";
	public static String DATALOADER_AD_PrintFormat_BY_UUID = "AD_PrintFormatByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_PrintFormat.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_PrintFormat_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_PrintFormat_BY_UUID;
	}
}
