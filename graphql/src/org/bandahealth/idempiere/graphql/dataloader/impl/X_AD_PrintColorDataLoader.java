package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_PrintColor;

/**
 * Data Loader for AD_PrintColor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_PrintColorDataLoader extends PODataLoader<X_AD_PrintColor> {
	public static String AD_PrintColor_BY_ID_DATA_LOADER = "AD_PrintColorByIdDataLoader";
	public static String AD_PrintColor_BY_UUID_DATA_LOADER = "AD_PrintColorByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_PrintColor.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_PrintColor_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_PrintColor_BY_UUID_DATA_LOADER;
	}
}
