package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDepreciationExp;

/**
 * Data Loader for A_Depreciation_Exp - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_A_Depreciation_ExpDataLoader extends PODataLoader<MDepreciationExp> {
	public static String DATALOADER_A_Depreciation_Exp_BY_ID = "A_Depreciation_ExpByIdDataLoader";
	public static String DATALOADER_A_Depreciation_Exp_BY_UUID = "A_Depreciation_ExpByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDepreciationExp.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_A_Depreciation_Exp_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_A_Depreciation_Exp_BY_UUID;
	}
}
