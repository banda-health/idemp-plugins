package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_ImpFormat_Row;

/**
 * Data Loader for AD_ImpFormat_Row - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ImpFormat_RowDataLoader extends PODataLoader<X_AD_ImpFormat_Row> {
	public static String AD_ImpFormat_Row_BY_ID_DATA_LOADER = "AD_ImpFormat_RowByIdDataLoader";
	public static String AD_ImpFormat_Row_BY_UUID_DATA_LOADER = "AD_ImpFormat_RowByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_ImpFormat_Row.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_ImpFormat_Row_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_ImpFormat_Row_BY_UUID_DATA_LOADER;
	}
}
