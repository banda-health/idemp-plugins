package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTable;

/**
 * Data Loader for AD_Table - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_TableDataLoader extends PODataLoader<MTable> {
	public static String AD_Table_BY_ID_DATA_LOADER = "AD_TableByIdDataLoader";
	public static String AD_Table_BY_UUID_DATA_LOADER = "AD_TableByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTable.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Table_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Table_BY_UUID_DATA_LOADER;
	}
}
