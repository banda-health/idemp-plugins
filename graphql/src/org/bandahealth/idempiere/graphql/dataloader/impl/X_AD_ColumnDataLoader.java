package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MColumn;

/**
 * Data Loader for AD_Column - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ColumnDataLoader extends PODataLoader<MColumn> {
	public static String AD_Column_BY_ID_DATA_LOADER = "AD_ColumnByIdDataLoader";
	public static String AD_Column_BY_UUID_DATA_LOADER = "AD_ColumnByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MColumn.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Column_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Column_BY_UUID_DATA_LOADER;
	}
}
