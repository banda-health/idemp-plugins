package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MUserDefInfoColumn;

/**
 * Data Loader for AD_UserDef_Info_Column - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_UserDef_Info_ColumnDataLoader extends PODataLoader<MUserDefInfoColumn> {
	public static String AD_UserDef_Info_Column_BY_ID_DATA_LOADER = "AD_UserDef_Info_ColumnByIdDataLoader";
	public static String AD_UserDef_Info_Column_BY_UUID_DATA_LOADER = "AD_UserDef_Info_ColumnByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MUserDefInfoColumn.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_UserDef_Info_Column_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_UserDef_Info_Column_BY_UUID_DATA_LOADER;
	}
}
