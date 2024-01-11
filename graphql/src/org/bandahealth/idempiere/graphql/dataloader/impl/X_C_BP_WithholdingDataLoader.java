package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_BP_Withholding;

/**
 * Data Loader for C_BP_Withholding - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BP_WithholdingDataLoader extends PODataLoader<X_C_BP_Withholding> {
	public static String C_BP_Withholding_BY_ID_DATA_LOADER = "C_BP_WithholdingByIdDataLoader";
	public static String C_BP_Withholding_BY_UUID_DATA_LOADER = "C_BP_WithholdingByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_BP_Withholding.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_BP_Withholding_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_BP_Withholding_BY_UUID_DATA_LOADER;
	}
}
