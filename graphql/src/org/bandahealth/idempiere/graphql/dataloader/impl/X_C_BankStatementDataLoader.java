package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MBankStatement;

/**
 * Data Loader for C_BankStatement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BankStatementDataLoader extends PODataLoader<MBankStatement> {
	public static String C_BankStatement_BY_ID_DATA_LOADER = "C_BankStatementByIdDataLoader";
	public static String C_BankStatement_BY_UUID_DATA_LOADER = "C_BankStatementByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBankStatement.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_BankStatement_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_BankStatement_BY_UUID_DATA_LOADER;
	}
}
