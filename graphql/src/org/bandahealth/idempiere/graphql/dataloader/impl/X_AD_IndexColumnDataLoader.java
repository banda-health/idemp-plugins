package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MIndexColumn;

/**
 * Data Loader for AD_IndexColumn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_IndexColumnDataLoader extends PODataLoader<MIndexColumn> {
	public static String AD_IndexColumn_BY_ID_DATA_LOADER = "AD_IndexColumnByIdDataLoader";
	public static String AD_IndexColumn_BY_UUID_DATA_LOADER = "AD_IndexColumnByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MIndexColumn.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_IndexColumn_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_IndexColumn_BY_UUID_DATA_LOADER;
	}
}
