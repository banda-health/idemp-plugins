package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCommissionLine;

/**
 * Data Loader for C_CommissionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_CommissionLineDataLoader extends PODataLoader<MCommissionLine> {
	public static String DATALOADER_C_CommissionLine_BY_ID = "C_CommissionLineByIdDataLoader";
	public static String DATALOADER_C_CommissionLine_BY_UUID = "C_CommissionLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCommissionLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_CommissionLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_CommissionLine_BY_UUID;
	}
}
