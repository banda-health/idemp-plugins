package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MBankStatementLine;

/**
 * Data Loader for C_BankStatementLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_BankStatementLineDataLoader extends PODataLoader<MBankStatementLine> {
	public static String DATALOADER_C_BankStatementLine_BY_ID = "C_BankStatementLineByIdDataLoader";
	public static String DATALOADER_C_BankStatementLine_BY_UUID = "C_BankStatementLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBankStatementLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_BankStatementLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_BankStatementLine_BY_UUID;
	}
}
