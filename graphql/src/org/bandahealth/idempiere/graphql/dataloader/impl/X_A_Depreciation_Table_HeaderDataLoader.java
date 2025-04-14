package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_A_Depreciation_Table_Header;

/**
 * Data Loader for A_Depreciation_Table_Header - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_A_Depreciation_Table_HeaderDataLoader extends PODataLoader<X_A_Depreciation_Table_Header> {
	public static String DATALOADER_A_Depreciation_Table_Header_BY_ID = "A_Depreciation_Table_HeaderByIdDataLoader";
	public static String DATALOADER_A_Depreciation_Table_Header_BY_UUID = "A_Depreciation_Table_HeaderByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_A_Depreciation_Table_Header.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_A_Depreciation_Table_Header_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_A_Depreciation_Table_Header_BY_UUID;
	}
}
