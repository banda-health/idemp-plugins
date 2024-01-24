package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MBankStatementLoader;

/**
 * Data Loader for C_BankStatementLoader - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BankStatementLoaderDataLoader extends PODataLoader<MBankStatementLoader> {
	public static String DATALOADER_C_BankStatementLoader_BY_ID = "C_BankStatementLoaderByIdDataLoader";
	public static String DATALOADER_C_BankStatementLoader_BY_UUID = "C_BankStatementLoaderByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBankStatementLoader.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_BankStatementLoader_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_BankStatementLoader_BY_UUID;
	}
}
