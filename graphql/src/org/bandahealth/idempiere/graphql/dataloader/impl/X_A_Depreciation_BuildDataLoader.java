package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDepreciationBuild;

/**
 * Data Loader for A_Depreciation_Build - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Depreciation_BuildDataLoader extends PODataLoader<MDepreciationBuild> {
	public static String A_Depreciation_Build_BY_ID_DATA_LOADER = "A_Depreciation_BuildByIdDataLoader";
	public static String A_Depreciation_Build_BY_UUID_DATA_LOADER = "A_Depreciation_BuildByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDepreciationBuild.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return A_Depreciation_Build_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return A_Depreciation_Build_BY_UUID_DATA_LOADER;
	}
}
