package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCommissionLine;

/**
 * Data Loader for C_CommissionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CommissionLineDataLoader extends PODataLoader<MCommissionLine> {
	public static String C_CommissionLine_BY_ID_DATA_LOADER = "C_CommissionLineByIdDataLoader";
	public static String C_CommissionLine_BY_UUID_DATA_LOADER = "C_CommissionLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCommissionLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_CommissionLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_CommissionLine_BY_UUID_DATA_LOADER;
	}
}
