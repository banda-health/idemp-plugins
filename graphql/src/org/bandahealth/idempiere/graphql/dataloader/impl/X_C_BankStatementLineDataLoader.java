package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MBankStatementLine;

/**
 * Data Loader for C_BankStatementLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BankStatementLineDataLoader extends PODataLoader<MBankStatementLine> {
	public static String C_BankStatementLine_BY_ID_DATA_LOADER = "C_BankStatementLineByIdDataLoader";
	public static String C_BankStatementLine_BY_UUID_DATA_LOADER = "C_BankStatementLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBankStatementLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_BankStatementLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_BankStatementLine_BY_UUID_DATA_LOADER;
	}
}
