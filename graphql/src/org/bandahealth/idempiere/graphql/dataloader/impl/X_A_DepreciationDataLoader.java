package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDepreciation;

/**
 * Data Loader for A_Depreciation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_DepreciationDataLoader extends PODataLoader<MDepreciation> {
	public static String A_Depreciation_BY_ID_DATA_LOADER = "A_DepreciationByIdDataLoader";
	public static String A_Depreciation_BY_UUID_DATA_LOADER = "A_DepreciationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDepreciation.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return A_Depreciation_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return A_Depreciation_BY_UUID_DATA_LOADER;
	}
}
