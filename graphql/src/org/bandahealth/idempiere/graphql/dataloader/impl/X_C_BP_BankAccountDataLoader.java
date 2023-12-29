package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MBPBankAccount;

/**
 * Data Loader for C_BP_BankAccount - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BP_BankAccountDataLoader extends PODataLoader<MBPBankAccount> {
	public static String C_BP_BankAccount_BY_ID_DATA_LOADER = "C_BP_BankAccountByIdDataLoader";
	public static String C_BP_BankAccount_BY_UUID_DATA_LOADER = "C_BP_BankAccountByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBPBankAccount.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_BP_BankAccount_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_BP_BankAccount_BY_UUID_DATA_LOADER;
	}
}
