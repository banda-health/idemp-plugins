package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBankAccount_BH;

/**
 * Data Loader for C_BankAccount - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_BankAccountDataLoader extends PODataLoader<MBankAccount_BH> {
	public static String DATALOADER_C_BankAccount_BY_ID = "C_BankAccountByIdDataLoader";
	public static String DATALOADER_C_BankAccount_BY_UUID = "C_BankAccountByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBankAccount_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_BankAccount_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_BankAccount_BY_UUID;
	}
}
