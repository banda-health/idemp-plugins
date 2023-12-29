package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_PrintTableFormat;

/**
 * Data Loader for AD_PrintTableFormat - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_PrintTableFormatDataLoader extends PODataLoader<X_AD_PrintTableFormat> {
	public static String AD_PrintTableFormat_BY_ID_DATA_LOADER = "AD_PrintTableFormatByIdDataLoader";
	public static String AD_PrintTableFormat_BY_UUID_DATA_LOADER = "AD_PrintTableFormatByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_PrintTableFormat.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_PrintTableFormat_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_PrintTableFormat_BY_UUID_DATA_LOADER;
	}
}
