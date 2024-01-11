package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MWithholding;

/**
 * Data Loader for C_Withholding - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_WithholdingDataLoader extends PODataLoader<MWithholding> {
	public static String C_Withholding_BY_ID_DATA_LOADER = "C_WithholdingByIdDataLoader";
	public static String C_Withholding_BY_UUID_DATA_LOADER = "C_WithholdingByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MWithholding.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_Withholding_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_Withholding_BY_UUID_DATA_LOADER;
	}
}
