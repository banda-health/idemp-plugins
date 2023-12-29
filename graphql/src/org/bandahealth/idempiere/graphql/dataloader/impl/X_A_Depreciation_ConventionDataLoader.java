package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDepreciationConvention;

/**
 * Data Loader for A_Depreciation_Convention - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Depreciation_ConventionDataLoader extends PODataLoader<MDepreciationConvention> {
	public static String A_Depreciation_Convention_BY_ID_DATA_LOADER = "A_Depreciation_ConventionByIdDataLoader";
	public static String A_Depreciation_Convention_BY_UUID_DATA_LOADER = "A_Depreciation_ConventionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDepreciationConvention.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return A_Depreciation_Convention_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return A_Depreciation_Convention_BY_UUID_DATA_LOADER;
	}
}
