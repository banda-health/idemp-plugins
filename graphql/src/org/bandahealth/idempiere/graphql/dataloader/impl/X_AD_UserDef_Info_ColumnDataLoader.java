package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MUserDefInfoColumn;

/**
 * Data Loader for AD_UserDef_Info_Column - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_UserDef_Info_ColumnDataLoader extends PODataLoader<MUserDefInfoColumn> {
	public static String DATALOADER_AD_UserDef_Info_Column_BY_ID = "AD_UserDef_Info_ColumnByIdDataLoader";
	public static String DATALOADER_AD_UserDef_Info_Column_BY_UUID = "AD_UserDef_Info_ColumnByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MUserDefInfoColumn.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_UserDef_Info_Column_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_UserDef_Info_Column_BY_UUID;
	}
}
