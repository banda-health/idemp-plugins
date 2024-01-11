package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRefTable;

/**
 * Data Loader for AD_Ref_Table - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Ref_TableDataLoader extends PODataLoader<MRefTable> {
	public static String AD_Ref_Table_BY_ID_DATA_LOADER = "AD_Ref_TableByIdDataLoader";
	public static String AD_Ref_Table_BY_UUID_DATA_LOADER = "AD_Ref_TableByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRefTable.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Ref_Table_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Ref_Table_BY_UUID_DATA_LOADER;
	}
}
