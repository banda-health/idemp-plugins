package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MViewColumn;

/**
 * Data Loader for AD_ViewColumn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ViewColumnDataLoader extends PODataLoader<MViewColumn> {
	public static String AD_ViewColumn_BY_ID_DATA_LOADER = "AD_ViewColumnByIdDataLoader";
	public static String AD_ViewColumn_BY_UUID_DATA_LOADER = "AD_ViewColumnByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MViewColumn.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_ViewColumn_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_ViewColumn_BY_UUID_DATA_LOADER;
	}
}
