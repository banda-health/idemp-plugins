package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_ImpFormat;

/**
 * Data Loader for AD_ImpFormat - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ImpFormatDataLoader extends PODataLoader<X_AD_ImpFormat> {
	public static String AD_ImpFormat_BY_ID_DATA_LOADER = "AD_ImpFormatByIdDataLoader";
	public static String AD_ImpFormat_BY_UUID_DATA_LOADER = "AD_ImpFormatByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_ImpFormat.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_ImpFormat_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_ImpFormat_BY_UUID_DATA_LOADER;
	}
}
