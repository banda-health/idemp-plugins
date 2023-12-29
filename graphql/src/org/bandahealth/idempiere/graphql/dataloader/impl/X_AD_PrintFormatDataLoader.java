package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_PrintFormat;

/**
 * Data Loader for AD_PrintFormat - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_PrintFormatDataLoader extends PODataLoader<X_AD_PrintFormat> {
	public static String AD_PrintFormat_BY_ID_DATA_LOADER = "AD_PrintFormatByIdDataLoader";
	public static String AD_PrintFormat_BY_UUID_DATA_LOADER = "AD_PrintFormatByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_PrintFormat.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_PrintFormat_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_PrintFormat_BY_UUID_DATA_LOADER;
	}
}
