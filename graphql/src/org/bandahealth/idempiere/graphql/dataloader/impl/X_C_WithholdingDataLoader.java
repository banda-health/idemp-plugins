package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MWithholding;

/**
 * Data Loader for C_Withholding - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_WithholdingDataLoader extends PODataLoader<MWithholding> {
	public static String DATALOADER_C_Withholding_BY_ID = "C_WithholdingByIdDataLoader";
	public static String DATALOADER_C_Withholding_BY_UUID = "C_WithholdingByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MWithholding.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_Withholding_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_Withholding_BY_UUID;
	}
}
