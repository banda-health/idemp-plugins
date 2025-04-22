package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MBankStatement;

/**
 * Data Loader for C_BankStatement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_BankStatementDataLoader extends PODataLoader<MBankStatement> {
	public static String DATALOADER_C_BankStatement_BY_ID = "C_BankStatementByIdDataLoader";
	public static String DATALOADER_C_BankStatement_BY_UUID = "C_BankStatementByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBankStatement.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_BankStatement_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_BankStatement_BY_UUID;
	}
}
