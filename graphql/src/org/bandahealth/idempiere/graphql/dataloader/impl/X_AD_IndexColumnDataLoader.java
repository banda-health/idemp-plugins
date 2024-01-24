package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MIndexColumn;

/**
 * Data Loader for AD_IndexColumn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_IndexColumnDataLoader extends PODataLoader<MIndexColumn> {
	public static String DATALOADER_AD_IndexColumn_BY_ID = "AD_IndexColumnByIdDataLoader";
	public static String DATALOADER_AD_IndexColumn_BY_UUID = "AD_IndexColumnByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MIndexColumn.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_IndexColumn_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_IndexColumn_BY_UUID;
	}
}
