package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDepreciationExp;

/**
 * Data Loader for A_Depreciation_Exp - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Depreciation_ExpDataLoader extends PODataLoader<MDepreciationExp> {
	public static String A_Depreciation_Exp_BY_ID_DATA_LOADER = "A_Depreciation_ExpByIdDataLoader";
	public static String A_Depreciation_Exp_BY_UUID_DATA_LOADER = "A_Depreciation_ExpByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDepreciationExp.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return A_Depreciation_Exp_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return A_Depreciation_Exp_BY_UUID_DATA_LOADER;
	}
}
