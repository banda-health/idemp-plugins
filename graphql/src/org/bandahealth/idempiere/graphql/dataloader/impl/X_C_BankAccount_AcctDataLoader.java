package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_BankAccount_Acct;

/**
 * Data Loader for C_BankAccount_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BankAccount_AcctDataLoader extends PODataLoader<X_C_BankAccount_Acct> {
	public static String C_BankAccount_Acct_BY_ID_DATA_LOADER = "C_BankAccount_AcctByIdDataLoader";
	public static String C_BankAccount_Acct_BY_UUID_DATA_LOADER = "C_BankAccount_AcctByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_BankAccount_Acct.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_BankAccount_Acct_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_BankAccount_Acct_BY_UUID_DATA_LOADER;
	}
}
