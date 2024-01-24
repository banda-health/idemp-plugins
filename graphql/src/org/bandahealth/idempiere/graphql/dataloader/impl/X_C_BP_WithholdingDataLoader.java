package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_BP_Withholding;

/**
 * Data Loader for C_BP_Withholding - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BP_WithholdingDataLoader extends PODataLoader<X_C_BP_Withholding> {
	public static String DATALOADER_C_BP_Withholding_BY_ID = "C_BP_WithholdingByIdDataLoader";
	public static String DATALOADER_C_BP_Withholding_BY_UUID = "C_BP_WithholdingByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_BP_Withholding.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_BP_Withholding_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_BP_Withholding_BY_UUID;
	}
}
