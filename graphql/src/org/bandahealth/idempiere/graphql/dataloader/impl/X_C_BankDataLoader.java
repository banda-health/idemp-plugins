package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MBank;

/**
 * Data Loader for C_Bank - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BankDataLoader extends PODataLoader<MBank> {
	public static String C_Bank_BY_ID_DATA_LOADER = "C_BankByIdDataLoader";
	public static String C_Bank_BY_UUID_DATA_LOADER = "C_BankByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBank.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_Bank_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_Bank_BY_UUID_DATA_LOADER;
	}
}
