package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDepreciationWorkfile;

/**
 * Data Loader for A_Depreciation_Workfile - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Depreciation_WorkfileDataLoader extends PODataLoader<MDepreciationWorkfile> {
	public static String A_Depreciation_Workfile_BY_ID_DATA_LOADER = "A_Depreciation_WorkfileByIdDataLoader";
	public static String A_Depreciation_Workfile_BY_UUID_DATA_LOADER = "A_Depreciation_WorkfileByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDepreciationWorkfile.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return A_Depreciation_Workfile_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return A_Depreciation_Workfile_BY_UUID_DATA_LOADER;
	}
}
