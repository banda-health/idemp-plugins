package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MColumn;

/**
 * Data Loader for AD_Column - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_ColumnDataLoader extends PODataLoader<MColumn> {
	public static String DATALOADER_AD_Column_BY_ID = "AD_ColumnByIdDataLoader";
	public static String DATALOADER_AD_Column_BY_UUID = "AD_ColumnByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MColumn.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Column_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Column_BY_UUID;
	}
}
