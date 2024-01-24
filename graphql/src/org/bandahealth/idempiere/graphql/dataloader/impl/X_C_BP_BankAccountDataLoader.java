package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MBPBankAccount;

/**
 * Data Loader for C_BP_BankAccount - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BP_BankAccountDataLoader extends PODataLoader<MBPBankAccount> {
	public static String DATALOADER_C_BP_BankAccount_BY_ID = "C_BP_BankAccountByIdDataLoader";
	public static String DATALOADER_C_BP_BankAccount_BY_UUID = "C_BP_BankAccountByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBPBankAccount.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_BP_BankAccount_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_BP_BankAccount_BY_UUID;
	}
}
