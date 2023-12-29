package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_A_Depreciation_Table_Header;

/**
 * Data Loader for A_Depreciation_Table_Header - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Depreciation_Table_HeaderDataLoader extends PODataLoader<X_A_Depreciation_Table_Header> {
	public static String A_Depreciation_Table_Header_BY_ID_DATA_LOADER = "A_Depreciation_Table_HeaderByIdDataLoader";
	public static String A_Depreciation_Table_Header_BY_UUID_DATA_LOADER = "A_Depreciation_Table_HeaderByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_A_Depreciation_Table_Header.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return A_Depreciation_Table_Header_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return A_Depreciation_Table_Header_BY_UUID_DATA_LOADER;
	}
}
