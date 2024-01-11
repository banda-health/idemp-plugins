package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCommissionAmt;

/**
 * Data Loader for C_CommissionAmt - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CommissionAmtDataLoader extends PODataLoader<MCommissionAmt> {
	public static String C_CommissionAmt_BY_ID_DATA_LOADER = "C_CommissionAmtByIdDataLoader";
	public static String C_CommissionAmt_BY_UUID_DATA_LOADER = "C_CommissionAmtByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCommissionAmt.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_CommissionAmt_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_CommissionAmt_BY_UUID_DATA_LOADER;
	}
}
