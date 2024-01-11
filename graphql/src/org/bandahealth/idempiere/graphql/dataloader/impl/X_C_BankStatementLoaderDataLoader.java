package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MBankStatementLoader;

/**
 * Data Loader for C_BankStatementLoader - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BankStatementLoaderDataLoader extends PODataLoader<MBankStatementLoader> {
	public static String C_BankStatementLoader_BY_ID_DATA_LOADER = "C_BankStatementLoaderByIdDataLoader";
	public static String C_BankStatementLoader_BY_UUID_DATA_LOADER = "C_BankStatementLoaderByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBankStatementLoader.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_BankStatementLoader_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_BankStatementLoader_BY_UUID_DATA_LOADER;
	}
}
