package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDepreciationMethod;

/**
 * Data Loader for A_Depreciation_Method - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Depreciation_MethodDataLoader extends PODataLoader<MDepreciationMethod> {
	public static String A_Depreciation_Method_BY_ID_DATA_LOADER = "A_Depreciation_MethodByIdDataLoader";
	public static String A_Depreciation_Method_BY_UUID_DATA_LOADER = "A_Depreciation_MethodByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDepreciationMethod.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return A_Depreciation_Method_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return A_Depreciation_Method_BY_UUID_DATA_LOADER;
	}
}
