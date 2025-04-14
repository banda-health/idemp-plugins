package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_PrintTableFormat;

/**
 * Data Loader for AD_PrintTableFormat - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_PrintTableFormatDataLoader extends PODataLoader<X_AD_PrintTableFormat> {
	public static String DATALOADER_AD_PrintTableFormat_BY_ID = "AD_PrintTableFormatByIdDataLoader";
	public static String DATALOADER_AD_PrintTableFormat_BY_UUID = "AD_PrintTableFormatByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_PrintTableFormat.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_PrintTableFormat_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_PrintTableFormat_BY_UUID;
	}
}
