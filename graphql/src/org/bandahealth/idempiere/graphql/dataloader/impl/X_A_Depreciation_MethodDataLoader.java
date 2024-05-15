package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDepreciationMethod;

/**
 * Data Loader for A_Depreciation_Method - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Depreciation_MethodDataLoader extends PODataLoader<MDepreciationMethod> {
	public static String DATALOADER_A_Depreciation_Method_BY_ID = "A_Depreciation_MethodByIdDataLoader";
	public static String DATALOADER_A_Depreciation_Method_BY_UUID = "A_Depreciation_MethodByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDepreciationMethod.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_A_Depreciation_Method_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_A_Depreciation_Method_BY_UUID;
	}
}
